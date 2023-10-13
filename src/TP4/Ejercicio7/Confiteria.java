package TP4.Ejercicio7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Confiteria {
    
    private Semaphore semLibre;
    private Semaphore semOcupado;
    private Semaphore semComer;
    
    public Confiteria() {
        semLibre = new Semaphore(1);
        semOcupado = new Semaphore(0);
        semComer = new Semaphore(0);
    }
    
    public void prepararComida() throws InterruptedException {
        semOcupado.acquire();
    }
    
    public void servirComida() {
        semComer.release();
    }
    
    public void ocuparEspacio() throws InterruptedException {
        semLibre.acquire();
    }
    
    public void esperarComida() {
        semOcupado.release();
    }
    
    public void empezarAComer() throws InterruptedException {
        semComer.acquire();
    }
    
    public void desocuparEspacio() {
        semLibre.release();
    }
}