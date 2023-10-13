package TP5.Ejercicio1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Piscina {
    
    private int limite;
    private Semaphore semDisponible;
    private Semaphore semSalida;
    
    public Piscina(int limite) {
        this.limite = limite;
        this.semDisponible = new Semaphore(limite);
        this.semSalida = new Semaphore(0);
    }
    
    
    
    public void solicitarAcceso() {
        
    }
    
    public void salirPiscina() {
        
    }
    
    public void dejarEntrar() {
        
    }
    
    public void liberarLugar() {
        
    }
    
    
}
