package TP4.Ejercicio6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Taxi {

    private Semaphore semLibre;
    private Semaphore semOcupado;
    private Semaphore semSalida;

    public Taxi() {
        semLibre = new Semaphore(1);
        semOcupado = new Semaphore(0);
        semSalida = new Semaphore(0);
    }
    
    public void subirseAlTaxi() throws InterruptedException {
        semLibre.acquire();
    }
    
    public void despertarTaxista() {
        semOcupado.release();
    }
    
    public void iniciarRecorrido() throws InterruptedException {
        semOcupado.acquire();
    }
    
    public void finalizarRecorrido() {
        semSalida.release();
    }
    
    public void bajarseDelTaxi() throws InterruptedException {
        semSalida.acquire();
    }
    
    public void dormirTaxista() {
        semLibre.release();
    }
}