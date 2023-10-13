package Problemas.BarberoDormilon;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Asiento {

    private Semaphore semSillon = new Semaphore(1);
    private Semaphore semBarbero = new Semaphore(0);
    private Semaphore semSalida = new Semaphore(0);

    public void ocuparSillon() throws InterruptedException {
        semSillon.acquire();
    }

    public void liberarSillon() {
        semSillon.release();
    }
    
    public void dormirBarbero() throws InterruptedException {
        semBarbero.acquire();
    }

    public void despertarBarbero() {
        semBarbero.release();
    }
    
    public void cortarElPelo() throws InterruptedException {
        semSalida.acquire();
    }

    public void terminaDeAtender() {
        semSalida.release();
    }
}