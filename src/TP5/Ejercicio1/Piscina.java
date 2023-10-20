package TP5.Ejercicio1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Piscina {

    private Semaphore semDisponible;

    public Piscina(int limite) {
        this.semDisponible = new Semaphore(limite);
    }

    public void dejarEntrar(int numero) throws InterruptedException {
        semDisponible.acquire();
        System.out.println("La persona " + numero + " entro y se esta bañando");
        Thread.sleep(500);
        System.out.println("La persona " + numero + " salio de la pile");
        semDisponible.release();

    }

}
