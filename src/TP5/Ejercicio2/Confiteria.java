package TP5.Ejercicio2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Confiteria {

    private Semaphore mutexMozo;
    private Semaphore mutexCocinero;
    private Semaphore semDisponibles;

    public Confiteria() {
        mutexMozo = new Semaphore(0);
        mutexCocinero = new Semaphore(0);
        semDisponibles = new Semaphore(2);
    }

    public void ocuparEspacio() throws InterruptedException {
        semDisponibles.acquire();
    }

    public void desocuparEspacio() {
        semDisponibles.release();
    }

    public void tomar() {
        mutexMozo.release();
        
        
    }

    public void comer() {
        mutexCocinero.release();

        
    }

    public void tomarYComer() {

        
        
    }

    public void prepararBebida() throws InterruptedException {
        mutexMozo.acquire();
        System.out.println("El mozo prepara la bebida");
        Thread.sleep(500);
        System.out.println("El mozo le dio la bebida");
        
        
        
        
    }

    public void servirBebida() {

        
        
    }

    public void prepararComida() {

        
        
    }

    public void servirComida() {

        
        
    }

    public void empezarAComer() {

        
        
    }

}
