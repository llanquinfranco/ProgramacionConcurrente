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
    
    public Recipiente(int capacidad) {
        this.capacidad = capacidad;
        this.ocupacion = 0;
        this.oxigenos = 0;
        this.hidrogenos = 0;
    }
    
    
}
