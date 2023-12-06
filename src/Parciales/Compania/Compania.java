package Parciales.Compania;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author franco.llanquin
 */
public class Compania {

    Random r = new Random();
    private int capitulosEspanol = 0;
    private int capitulosIngles = 0;
    private Queue<Object> colaTraduccion = new LinkedList<>();
    private Lock espanol = new ReentrantLock();
    private Lock ingles = new ReentrantLock();
    private Lock traductor = new ReentrantLock();
    private Lock filmador = new ReentrantLock();    // se utiliza mas que nada para mutex
    private Condition esperaEspanol = espanol.newCondition();
    private Condition esperaIngles = ingles.newCondition();
    private Condition esperaTraducir = traductor.newCondition();
    private int i = 1;  //contador de capitulos que tiene la serie

    public void filmarCapitulo() {
        try {
            filmador.lock();
            System.out.println("Se filmo el capitulo " + i + " de la serie");
            colaTraduccion.add("Capitulo " + i + " de la serie");
            i++;
            capitulosEspanol++;
            try {
                traductor.lock();
                esperaTraducir.signalAll();
            } finally {
                traductor.unlock();
            }
            try {
                espanol.lock();
                esperaEspanol.signalAll();
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
                esperaTraducir.await(); // si no hay caps a traducir, espera
            }
            System.out.println("El " + Thread.currentThread().getName() + " tradujo el "
                    + colaTraduccion.peek() + " al ingles");
            colaTraduccion.remove();    // ya lo traduci, lo elimino de la cola
            capitulosIngles++;
            try {
                ingles.lock();
                esperaIngles.signalAll();   // notifica que ya se traducio un capitulo
            } finally {
                ingles.unlock();
            }
        } finally {
            traductor.unlock();
        }
    }

    public int seleccionarEspanol() throws InterruptedException {
        int numero;
        try {
            espanol.lock();
            while (capitulosEspanol == 0) {
                esperaEspanol.await();  // si todavia no hay capitulos en espanol, espera
            }
            //numero = r.nextInt(capitulosEspanol);
            numero = r.nextInt((capitulosEspanol - 1) + 1) + 1;
            System.out.println("El " + Thread.currentThread().getName() + " selecciono el capitulo "
                    + numero + " de la serie (en Espanol)");
        } finally {
            espanol.unlock();
        }
        return numero;
    }

    public void terminarEspanol(int numero) {
        System.out.println("El " + Thread.currentThread().getName() + " termino de ver el capitulo "
                + numero + " de la serie (en Espanol)");
    }

    public int seleccionarIngles() throws InterruptedException {
        int numero;
        try {
            ingles.lock();
            while (capitulosIngles == 0) {
                esperaIngles.await();   // si todavia no se traducio ningun capitulo, espera
            }
            //numero = r.nextInt(capitulosIngles);
            numero = r.nextInt((capitulosIngles - 1) + 1) + 1;
            System.out.println("El " + Thread.currentThread().getName() + " selecciono el capitulo "
                    + numero + " de la serie (en Ingles)");
        } finally {
            ingles.unlock();
        }
        return numero;
    }

    public void terminarIngles(int numero) {
        System.out.println("El " + Thread.currentThread().getName() + " termino de ver el capitulo "
                + numero + " de la serie (en Ingles)");
    }

}
