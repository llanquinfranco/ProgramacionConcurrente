package TP7.Ejercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Cocina {

    private int carne;
    private int vegetales;
    private int pasta;
    private Lock lockCarne;             // Locks distintos para no bloquear a los
    private Lock lockVegetales;         // otros tipos de cocinero como me paso en
    private Lock lockPasta;             // el parcial con los tipos de botella
    private Condition esperaCarne;
    private Condition esperaVegetales;
    private Condition esperaPasta;

    public Cocina() {
        this.carne = 3;
        this.vegetales = 3;             // La cocina tiene 3 ingredientes de cada uno
        this.pasta = 3;
        this.lockCarne = new ReentrantLock();
        this.lockVegetales = new ReentrantLock();
        this.lockPasta = new ReentrantLock();
        this.esperaCarne = lockCarne.newCondition();
        this.esperaVegetales = lockVegetales.newCondition();
        this.esperaPasta = lockPasta.newCondition();
    }

    public void cocinarCarne() throws InterruptedException {
        try {
            lockCarne.lock();
            while (carne == 0) {
                esperaCarne.await();
            }
            carne--;
            System.out.println("El " + Thread.currentThread().getName() + " tomo un pedazo de carne del deposito");
            System.out.println("Carne disponible: " + carne);
            System.out.println(Thread.currentThread().getName() + " cocinando carne a la parrilla...");
        } finally {
            lockCarne.unlock();
        }
    }
    
    public void reponerCarne() {
        try {
            lockCarne.lock();
            System.out.println(Thread.currentThread().getName() + " termino de cocinar carne a la parrilla");
            carne++;
            System.out.println("El " + Thread.currentThread().getName() + " repuso un pedazo de carne en el deposito");
            System.out.println("Carne disponible: " + carne);
            esperaCarne.signalAll();
        } finally {
            lockCarne.unlock();
        }
    }
    
    public void cocinarEnsalada() throws InterruptedException {
        try {
            lockVegetales.lock();
            while (vegetales == 0) {
                esperaVegetales.await();
            }
            vegetales--;
            System.out.println("El " + Thread.currentThread().getName() + " tomo un vegetal del deposito");
            System.out.println("Vegetales disponibles: " + vegetales);
            System.out.println(Thread.currentThread().getName() + " cocinando ensalada de vegetales...");
        } finally {
            lockVegetales.unlock();
        }
    }
    
    public void reponerVegetales() {
        try {
            lockVegetales.lock();
            System.out.println(Thread.currentThread().getName() + " termino de cocinar ensalada de vegetales");
            vegetales++;
            System.out.println("El " + Thread.currentThread().getName() + " repuso un vegetal en el deposito");
            System.out.println("Vegetales disponibles: " + vegetales);
        } finally {
            lockVegetales.unlock();
        }
    }
    
    public void cocinarPasta() throws InterruptedException {
        try {
            lockPasta.lock();
            while (pasta == 0) {
                esperaPasta.await();
            }
            pasta--;
            System.out.println("El " + Thread.currentThread().getName() + " tomo una pasta del deposito");
            System.out.println("Pastas disponibles: " + pasta);
            System.out.println(Thread.currentThread().getName() + " cocinando pasta al pesto...");
        } finally {
            lockPasta.unlock();
        }
    }
    
    public void reponerPasta() {
        try {
            lockPasta.lock();
            System.out.println(Thread.currentThread().getName() + " termino de cocinar pasta al pesto");
            pasta++;
            System.out.println("El " + Thread.currentThread().getName() + " repuso una pasta en el deposito");
            System.out.println("Pastas disponibles: " + pasta);
        } finally {
            lockPasta.unlock();
        }
    }
}
