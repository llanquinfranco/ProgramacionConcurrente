package TP5.Ejercicio5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Tren {

    private int espacio;
    private Semaphore semTicket;
    private Semaphore semAcceso; //espacio
    private Semaphore semViaje;
    private Semaphore semSalida;
    private Semaphore mutex = new Semaphore(0);

    public Tren(int espacio) {
        this.espacio = espacio;
        this.semTicket = new Semaphore(0);
        this.semAcceso = new Semaphore(espacio);
        this.semViaje = new Semaphore(0);
        this.semSalida = new Semaphore(0);
    }
    
    public void comprarTicket(int numero) {
        System.out.println("El Cliente " + numero + " quiere comprar un ticket");
        semTicket.release();
    }
    
    public void venderTicket() throws InterruptedException {
        semTicket.acquire();
        System.out.println("Se vendio un Ticket");
        mutex.release();
    }
    
    public void entrar(int numero) throws InterruptedException {
        mutex.acquire();
        semAcceso.acquire();
        System.out.println("El Cliente " + numero + " entro al Tren");
        semViaje.release();
    }
    
    public void iniciarRecorrido() throws InterruptedException {
        semViaje.acquire(espacio);
        System.out.println("Inicio el Recorrido");
        Thread.sleep(1000);
        System.out.println("Finalizo el Recorrido");
        semSalida.release(espacio);
    }
    
    public void bajar(int numero) throws InterruptedException {
        semSalida.acquire();
        System.out.println("El Cliente " + numero + " se bajo del Tren");
        semAcceso.release();
    }
    
    
}
