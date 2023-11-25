package Recuperatorio.AtomosLocksMonitores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Recipiente {
    
    private int capacidad;
    private int ocupacion;
    private int oxigenos;
    private int hidrogenos;
    private Lock accesoRecipiente;
    private Condition esperaHidrogeno;
    private Condition esperaOxigeno;
    
    
    public Recipiente(int capacidad) {
        this.capacidad = capacidad;
        this.ocupacion = 0;
        this.oxigenos = 0;
        this.hidrogenos = 0;
    }
    
    public synchronized void Olisto() {
        System.out.println("El " + Thread.currentThread().getName() + " esta listo");
        oxigenos++;
        if(hidrogenos >= 2 && oxigenos >= 1) {
            this.hacerAgua();
        }
    }
    
    
    public synchronized void Hlisto() {
        System.out.println("El " + Thread.currentThread().getName() + " esta listo");
        hidrogenos++;
        if(hidrogenos >= 2 && oxigenos >= 1) {
            this.hacerAgua();
        }
        
        
    }
    
    private synchronized void hacerAgua() {
        
        
        
        
    }
}
