package TP8.Ejercicio5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Olla {
    // Con locks para notifica al canibal que lo había despertado previamente
    
    private int capacidad;
    private int raciones;
    private Lock accesoOlla;
    private Condition canibales;
    private Condition cocinero;

    public Olla(int capacidad) {
        this.capacidad = capacidad;
        this.raciones = 0; // La olla arranca vacia
        this.accesoOlla = new ReentrantLock();
        this.canibales = accesoOlla.newCondition();
        this.cocinero = accesoOlla.newCondition();
    }
    
    public void comer() {
        
        
        
        
        
    }
    
    public void cocinar() {
        
        
    }
    
}
