package TP6.Ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Sala {
    
    private int cantUsados;
    private Semaphore libres;
    private Semaphore ocupados;
    private Semaphore mutex;
    
    public Sala(int limiteMaximo) {
        this.cantUsados = 0;
        this.mutex = new Semaphore(1);
        this.libres = new Semaphore(limiteMaximo);
        this.ocupados = new Semaphore(0);
    }
    
    public void entrar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " quiere entrar a la Sala");
        libres.acquire();
        mutex.acquire();
        cantUsados++;
        System.out.println(Thread.currentThread().getName() + " entro a la Sala y esta estudiando");
        System.out.println("Hay " + cantUsados + " estudiantes en la Sala");
        mutex.release();
        ocupados.release();
    }
    
    public void salir() throws InterruptedException {
        ocupados.acquire();
        mutex.acquire();
        cantUsados--;
        System.out.println(Thread.currentThread().getName() + " salio de la sala");
        System.out.println("Hay " + cantUsados + " estudiantes en la Sala");
        mutex.release();
        libres.release();
    }
    
}
