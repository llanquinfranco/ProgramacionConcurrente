package TP8.Ejercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Caja {

    int pesoActual;
    int pesoMaximo;
    Lock accesoCaja;
    Condition empaquetadores;
    Condition brazo;
    boolean hayCaja; // Requiere que haya una caja en la zona de relleno ¿? 

    public Caja(int peso) {
        this.pesoActual = 0;
        this.pesoMaximo = peso;
        this.accesoCaja = new ReentrantLock();
        this.empaquetadores = accesoCaja.newCondition();
        this.brazo = accesoCaja.newCondition();
        this.hayCaja = true;
    }
    
    public void soltarPastel(int peso) throws InterruptedException {
        /* Provoca que el proceso que lo invoca quede bloqueado hasta que el empaquetador
        suelte el pastel que acaba de tomar en la caja del área de relleno. Es necesario
        que haya una caja en el área de rellenado, que el robot empaquetador en cuestión 
        tenga un pastel y que la inclusión de ese pastel en la caja no haga sobrepasar 
        el peso máximo permitido */
        try {
            accesoCaja.lock();
            if(peso < (pesoMaximo - pesoActual)) {
                brazo.signal();
            }
            while(!hayCaja) {
                empaquetadores.await();
            }
            
            
            
            
        } finally {
            accesoCaja.unlock();
        }   
        
        
        
    }
    
    
    
    
    
    
    
    
/*
        try {
            accesoCaja.lock();
        } finally {
            accesoCaja.unlock();
        }    
*/    
    
    

}
