package TP5.Ejercicio7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Mirador {
    
    private Semaphore escalones;
    private Semaphore toboganes;
    private Semaphore semBajada;
    
    public Mirador(int capacidad) {
        this.escalones = new Semaphore(capacidad);
        this.toboganes = new Semaphore(2);
        this.semBajada = new Semaphore(0);
    }
    
    public void subirAlMirador(int numero) throws InterruptedException {
        escalones.acquire();
        
        
    }
    
    public void hacerBajar() {
        
        
        
    }
    
    public void bajarPorTobogan(int numero) throws InterruptedException {
        semBajada.acquire();
        
        
        
        escalones.release();
    }
}
