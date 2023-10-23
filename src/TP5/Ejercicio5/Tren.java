package TP5.Ejercicio5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Tren {

    private int espacio;
    private int salieron;           // Para contar cuantos van saliendo al finalizar el recorrido
    private Semaphore semTicket;    // Para comprar el ticket
    private Semaphore semAcceso;    // Para darle el ticket al pasajero y que espere a entrar
    private Semaphore semAsientos;  // Para ocupar un asiento y entrar de una vez
    private Semaphore semViaje;     // Para iniciar el recorrido (solo si esta lleno)
    private Semaphore semSalida;    // Para indicar que pueden empezar a salir del tren
    private Semaphore mutex;        // Para la exclusion mutua al incrementar salieron

    public Tren(int espacio) {
        this.espacio = espacio;
        this.salieron = 0;
        this.semTicket = new Semaphore(0);
        this.semAcceso = new Semaphore(0);
        this.semAsientos = new Semaphore(espacio);
        this.semViaje = new Semaphore(0);
        this.semSalida = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }
    
    public void comprarTicket(int numero) {
        System.out.println("El Cliente " + numero + " quiere comprar un ticket");
        semTicket.release();
    }
    
    public void venderTicket() throws InterruptedException {
        semTicket.acquire();
        System.out.println("Se vendio un Ticket");
        semAcceso.release();
    }
    
    public void entrar(int numero) throws InterruptedException {
        semAcceso.acquire();
        System.out.println("El Cliente " + numero + " tiene su ticket, esperando a entrar");
        semAsientos.acquire();
        System.out.println("El Cliente " + numero + " entro al Tren");
        semViaje.release();
    }
    
    public void iniciarRecorrido() throws InterruptedException {
        semViaje.acquire(espacio);
        System.out.println("El Tren Turistico inicio el Recorrido -----------------------------------");
        Thread.sleep(1000);
        System.out.println("El Tren Turistico finalizo el Recorrido ---------------------------------");
        semSalida.release(espacio);
    }
    
    public void bajar(int numero) throws InterruptedException {
        semSalida.acquire();
        mutex.acquire();
        System.out.println("El Cliente " + numero + " se bajo del Tren");
        salieron++;
        mutex.release();
        // Una vez que salgan todos, empiezan a subir los que quieren entrar
        if(salieron == espacio) {
            semAsientos.release(espacio);
            salieron = 0;
        }
    }
    
}
