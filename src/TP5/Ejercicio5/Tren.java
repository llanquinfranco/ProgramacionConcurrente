package TP5.Ejercicio5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Tren {

    private int espacio;
    private Semaphore semTicket;
    private Semaphore semAcceso;
    private Semaphore semViaje;
    private Semaphore semSalida;

    public Tren(int espacio) {
        this.espacio = espacio;
        this.semTicket = new Semaphore(0);
        this.semAcceso = new Semaphore(0);
        this.semViaje = new Semaphore(0);
        this.semSalida = new Semaphore(0);
    }

    public void comprarTicket(int numero) {
        System.out.println("El Cliente " + numero + " quiere comprar un ticket");
        semTicket.release();
    }

    public void venderTicket() throws InterruptedException {
        semTicket.acquire();
        System.out.println("El Vendedor de Tickets vendio un ticket");
        semAcceso.release();
    }

    public void subirAlTren(int numero) throws InterruptedException {
        semAcceso.acquire();
        System.out.println("El Cliente " + numero + " ocupo un lugar del tren");
        semViaje.release();
    }
    
    public void iniciarRecorrido() throws InterruptedException {
        semViaje.acquire(espacio);
        System.out.println("El Tren Turistico inicio el Recorrido");
        Thread.sleep(1000);
        System.out.println("El Tren Turistico finalizo el Recorrido");
        semSalida.release(espacio);
    }
    
    public void bajarseDelTren(int numero) throws InterruptedException {
        semSalida.acquire();
        System.out.println("El Cliente " + numero + " salio del Tren");
    }
}
