package TP4.Ejercicio5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Impresora {

    private int id;
    private char tipo;
    private boolean enUso;
    private final Semaphore semaforo;
    private final Semaphore mutex;

    public Impresora(int id, char tipo) {
        this.id = id;
        this.tipo = tipo;
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
            System.out.println("CLIENTE " + numero + " (" + this.tipo + ") USANDO IMPRESORA " + this.id + " (" + this.tipo + ")");
            System.out.println("Imprimiendo...");
        }
        mutex.release();
        return exito;
    }

    public boolean liberar(int numero) {
        enUso = false;
        semaforo.release();
        System.out.println("CLIENTE " + numero + " (" + this.tipo + ") LIBERA IMPRESORA " + this.id + " (" + this.tipo + ")");
        return enUso;
    }
}
