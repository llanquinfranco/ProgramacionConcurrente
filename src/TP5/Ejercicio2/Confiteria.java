package TP5.Ejercicio2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Confiteria {

    private Semaphore semDisponibles;
    private Semaphore mutexMozo;
    private Semaphore mutexCocinero;
    private Semaphore tomar;
    private Semaphore comer;

    public Confiteria() {
        semDisponibles = new Semaphore(2);
        mutexMozo = new Semaphore(0);
        mutexCocinero = new Semaphore(0);
        tomar = new Semaphore(0);
        comer = new Semaphore(0);
    }

    public void ocuparEspacio(int numero) throws InterruptedException {
        semDisponibles.acquire();
        System.out.println("El empleado " + numero + " ocupo un lugar");
    }

    public void desocuparEspacio(int numero) {
        System.out.println("El empleado " + numero + " desocupo un lugar");
        semDisponibles.release();
    }

    public void tomar(int numero) throws InterruptedException {
        tomar.acquire();
        System.out.println("El empleado " + numero + " esta tomando");
        Thread.sleep(500);
    }

    public void comer(int numero) throws InterruptedException {
        comer.acquire();
        System.out.println("El empleado " + numero + " esta comiendo");
        Thread.sleep(1000);
    }

    public void prepararBebida() throws InterruptedException {
        mutexMozo.acquire();
        System.out.println("El mozo esta haciendo un trago");
        tomar.release();
    }

    public void prepararComida() throws InterruptedException {
        mutexCocinero.acquire();
        System.out.println("El cocinero esta cocinando");
        comer.release();
    }

    public void pedirBebida(int numero) {
        System.out.println("El empleado " + numero + " pidio la bebida");
        mutexMozo.release();
    }

    public void pedirComida(int numero) {
        System.out.println("El empleado " + numero + " pidio la comida");
        mutexCocinero.release();
    }
}
