package TP8.Ejercicio5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Olla {

    private int capacidad;
    private int raciones;
    private Semaphore semRaciones;
    private Semaphore mutexCanibal;
    private Semaphore mutexCocinero;

    public Olla(int capacidad) {
        this.capacidad = capacidad;
        this.raciones = capacidad;
        this.semRaciones = new Semaphore(capacidad);
        this.mutexCanibal = new Semaphore(1);
        this.mutexCocinero = new Semaphore(0);
    }

    public void comer() throws InterruptedException {
        mutexCanibal.acquire();
        if (raciones == 0) {
            System.out.println("La olla esta vacia. El " + Thread.currentThread().getName() + " notifico al cocinero");
            mutexCocinero.release();    // Despierto al cocinero
            semRaciones.acquire();  // Una vez llena, empieza a comer
            System.out.println("El " + Thread.currentThread().getName() + " comio de la olla");
            raciones--;
            System.out.println("Ahora quedan " + raciones + " raciones");
        } else {
            semRaciones.acquire();  // Come tranqui
            raciones--;
            System.out.println("El " + Thread.currentThread().getName() + " comio de la olla");
            System.out.println("Ahora quedan " + raciones + " raciones");
        }
        mutexCanibal.release();
    }

    public void cocinar() throws InterruptedException {
        mutexCocinero.acquire();    // El cocinero se despierta
        raciones = capacidad;
        System.out.println("El cocinero de la tribu lleno la olla con " + raciones + " raciones");
        semRaciones.release(raciones);  // El cocinero lleno la olla
    }

}
