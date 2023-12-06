package Parciales.Compania;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Compania {

    Random r = new Random();
    private Lock filmador = new ReentrantLock();
    private Lock traductor = new ReentrantLock();
    private Lock espanol = new ReentrantLock();
    private Lock ingles = new ReentrantLock();
    private Condition esperaTraductor = traductor.newCondition();
    private Condition esperaEspanol = espanol.newCondition();
    private Condition esperaIngles = ingles.newCondition();
    private int i = 0;
    private Queue colaTraduccion = new LinkedList<>();
    private int cantEspanol = 0;
    private int cantIngles = 0;

    public void filmarCapitulo() {
        try {
            filmador.lock();
            i++;
            System.out.println("El filmador filmo el capitulo " + i + " de la serie");
            cantEspanol++;
            colaTraduccion.add(i);

            try {
                traductor.lock();
                esperaTraductor.signal();
            } finally {
                traductor.unlock();
            }

            try {
                espanol.lock();
                esperaEspanol.signal();
            } finally {
                espanol.unlock();
            }
        } finally {
            filmador.unlock();
        }
    }

    public void traducirCapitulo() throws InterruptedException {
        try {
            traductor.lock();
            while (colaTraduccion.isEmpty()) {
                esperaTraductor.await();
            }
            Object capitulo = colaTraduccion.peek();
            System.out.println("El " + Thread.currentThread().getName() + " traducio el capitulo " + capitulo + " de la serie");
            colaTraduccion.remove();
            cantIngles++;
            
            try {
                ingles.lock();
                esperaIngles.signal();
            } finally {
                ingles.unlock();
            }
        } finally {
            traductor.unlock();
        }
    }

    public int verEspanol() throws InterruptedException {
        int numero;
        try {
            espanol.lock();
            while (cantEspanol == 0) {
                esperaEspanol.await();
            }
            numero = r.nextInt(1, cantEspanol);
            System.out.println("El " + Thread.currentThread().getName() + " selecciono el capitulo " + numero + " en espanol");
        } finally {
            espanol.unlock();
        }
        return numero;
    }

    public void terminarEspanol(int numero) {
        System.out.println("El " + Thread.currentThread().getName() + " termino de ver el episodio " + numero + " en espanol");
    }

    public int verIngles() throws InterruptedException {
        int numero;
        try {
            ingles.lock();
            while (cantIngles == 0) {
                esperaIngles.await();
            }
            numero = r.nextInt(1, cantIngles);
            System.out.println("El " + Thread.currentThread().getName() + " selecciono el capitulo " + numero + " en ingles");
        } finally {
            ingles.unlock();
        }
        return numero;
    }

    public void terminarIngles(int numero) {
        System.out.println("El " + Thread.currentThread().getName() + " termino de ver el episodio " + numero + " en ingles");
    }
}
