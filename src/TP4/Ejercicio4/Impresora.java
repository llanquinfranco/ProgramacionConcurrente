package TP4.Ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Impresora {

    int id;
    private boolean enUso;
    private final Semaphore semaforo;
    private final Semaphore mutex;

    public Impresora(int id) {
        this.id = id;
        this.enUso = false;
        this.semaforo = new Semaphore(1);
        this.mutex = new Semaphore(1);
    }
    
    public int getId() {
        return id;
    }

    public boolean usar(int numero) throws InterruptedException {
        mutex.acquire();
        boolean exito = false;
        if (!enUso) {
            semaforo.acquire();
            exito = true;
            enUso = true;
            System.out.println("CLIENTE " + numero + " USANDO IMPRESORA " + this.getId());
            System.out.println("Imprimiendo...");
        }
        mutex.release();
        return exito;
    }

    public boolean liberar(int numero) {
        enUso = false;
        semaforo.release();
        System.out.println("CLIENTE " + numero + " LIBERA IMPRESORA " + this.getId());
        return enUso;
    }
}
