package TP8.Ejercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Mostrador {

    Queue<Integer> colaPasteles;
    Lock accesoMostrador;
    Condition empaquetadores;

    public Mostrador() {
        this.colaPasteles = new LinkedList<>();
        this.accesoMostrador = new ReentrantLock();
        this.empaquetadores = accesoMostrador.newCondition();
    }

    public void hornear(char tipo, int peso) {
        try {
            accesoMostrador.lock();
            colaPasteles.add(peso);
            System.out.println("El Horno " + tipo + " horneo un pastel de " + peso + " kilos");
            empaquetadores.signal();    // Notifica al empaquetador que ya hay un pastel
        } finally {
            accesoMostrador.unlock();
        }
    }

    public int tomarPastel() throws InterruptedException {
        /* Provoca que el proceso que lo invoca quede bloqueado hasta que el empaquetador
        toma el pastel más cercano al mostrador, indicando el peso del mismo */
        int pesoPastel;
        try {
            accesoMostrador.lock();
            while (colaPasteles.isEmpty()) {    // Si no hay pasteles en la cinta, que espere
                empaquetadores.await();
            }
            pesoPastel = colaPasteles.peek();   
            colaPasteles.poll();    // remove tmb ¿?
            System.out.println("El " + Thread.currentThread().getName() + " agarro un pastel de " + pesoPastel + " kilos");
        } finally {
            accesoMostrador.unlock();
        }
        return pesoPastel;
    }

}
