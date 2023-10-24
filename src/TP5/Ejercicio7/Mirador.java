package TP5.Ejercicio7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Mirador {
    
    private Semaphore escalones;
    private Semaphore tobogan1;
    private Semaphore tobogan2;
    private Semaphore semBajada;
    
    public Mirador(int capacidad) {
        this.escalones = new Semaphore(capacidad);
        this.tobogan1 = new Semaphore(1);
        this.tobogan2 = new Semaphore(1);
        this.semBajada = new Semaphore(0);
    }
    
    public void subirAlMirador() {
        
        
        
    }
    
    public void controlar() {
        
        
        
    }
    
    public void bajarPorTobogan() throws InterruptedException {
        semBajada.acquire();
        
        
        
        
    }
}
