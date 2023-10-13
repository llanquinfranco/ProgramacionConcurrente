package TP4.Ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Turnos {
    Semaphore mutex1 = new Semaphore(1); // Inicializo en 1 xq es el que arranca
    Semaphore mutex2 = new Semaphore(0); // Los demas, esperan un permiso
    Semaphore mutex3 = new Semaphore(0);

    public void ejecutar() throws InterruptedException {
        switch (Thread.currentThread().getName()) {
            case "P1":
                imprimirP1();
                break;
            case "P2":
                imprimirP2();
                break;
            case "P3":
                imprimirP3();
                break;
        }
    }

    private void imprimirP1() throws InterruptedException {
        mutex1.acquire();
        System.out.println("Ejecutando P1");
        Thread.sleep(500);
        mutex3.release();
    }

    private void imprimirP2() throws InterruptedException {
        mutex2.acquire();
        System.out.println("Ejecutando P2");
        Thread.sleep(500);
        mutex1.release();
    }

    private void imprimirP3() throws InterruptedException {
        mutex3.acquire();
        System.out.println("Ejecutando P3");
        Thread.sleep(500);
        mutex2.release();
    }
}