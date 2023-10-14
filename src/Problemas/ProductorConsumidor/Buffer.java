package Problemas.ProductorConsumidor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Buffer {

    private int capacidad;
    private int cantidadUsados;
    private Semaphore vacios;  // VACIO para agregar
    private Semaphore llenos;  // LLENO para sacar elementos
    private Semaphore mutex;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        this.cantidadUsados = 0;
        vacios = new Semaphore(capacidad);
        llenos = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    public synchronized boolean puedeAgregar(int num) {
        return (num <= (capacidad - cantidadUsados));
    }

    public void agregar(int num, String nombre) throws InterruptedException {
        vacios.acquire(num);
        mutex.acquire();
        System.out.println("El productor " + nombre + " agrego " + num + " productos en la cinta");
        cantidadUsados = cantidadUsados + num;
        System.out.println("Ahora hay " + this.cantidadUsados + " cosas en la cinta");
        mutex.release();
        llenos.release(num);
    }

    public synchronized boolean puedeSacar(int num) {
        return cantidadUsados > 0 && num <= cantidadUsados;
    }

    public void sacar(int num, String nombre) throws InterruptedException {
        llenos.acquire(num);
        mutex.acquire();
        System.out.println("El consumidor " + nombre + " saco " + num + " productos de la cinta");
        cantidadUsados = cantidadUsados - num;
        System.out.println("Ahora hay " + this.cantidadUsados + " cosas en la cinta");
        mutex.release();
        vacios.release(num);
    }
}
