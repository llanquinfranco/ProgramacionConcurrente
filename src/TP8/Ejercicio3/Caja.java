package TP8.Ejercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Caja {

    private int pesoActual;
    private int pesoMaximo;
    private Lock accesoCaja;
    private Condition empaquetadores;
    private Condition brazo;
    private boolean hayCaja;    // Requiere que haya una caja en la zona de relleno
    private boolean estaLlena;
    
    public Caja(int peso) {
        this.pesoActual = 0;
        this.pesoMaximo = peso;
        this.accesoCaja = new ReentrantLock();
        this.empaquetadores = accesoCaja.newCondition();
        this.brazo = accesoCaja.newCondition();
        this.hayCaja = true;
        this.estaLlena = false;
    }
    
    public void soltarPastel(int peso) throws InterruptedException {
        /* Provoca que el proceso que lo invoca quede bloqueado hasta que el empaquetador
        suelte el pastel que acaba de tomar en la caja del área de relleno. Es necesario
        que haya una caja en el área de rellenado, que el robot empaquetador en cuestión 
        tenga un pastel y que la inclusión de ese pastel en la caja no haga sobrepasar 
        el peso máximo permitido */
        try {
            accesoCaja.lock();
            if(peso > (pesoMaximo - pesoActual)) {
                estaLlena = true;
                brazo.signal(); // Si no queda espacio, avisa al brazo que cambie la caja
            }
            while(!hayCaja || estaLlena) {  // Espera mientras cambian la caja
                empaquetadores.await();
            }
            pesoActual = pesoActual + peso;
            System.out.println("El " + Thread.currentThread().getName() + " puso un pastel de " + peso + " kilos en la caja");
            System.out.println("Estado de la caja: " + pesoActual + " / " + pesoMaximo);
            empaquetadores.signal();    // Creo q es necesario xq sino tarda en despertar un empaquetador
        } finally {
            accesoCaja.unlock();
        }   
    }
    
    public void retirarCaja() throws InterruptedException {
        /* Hace que el proceso que lo invoca quede bloqueado hasta que la caja que 
        estaba siendo llenada es retirada por el brazo auxiliar . Requiere que 
        haya una caja en la zona de relleno */
        try {
            accesoCaja.lock();
            while(!estaLlena) {
                brazo.await();  // Espera mientras se pueda poner pasteles en la caja
            }
            System.out.println("El brazo retiro la caja llena");
            hayCaja = false;
        } finally {
            accesoCaja.unlock();
        }    
    }
    
    public void reponerCaja() {
        /* Hace que el proceso que lo invoca quede bloqueado hasta que el brazo 
        auxiliar coloque una caja vacía en el área de relleno. No debe haber 
        ninguna caja en la zona de rellenado */
        try {
            accesoCaja.lock();
            pesoActual = 0;
            System.out.println("El brazo coloco una caja vacia");
            estaLlena = false;
            hayCaja = true;
            empaquetadores.signal();    // Cuando hace el cambio de caja, avisa al empaquetador
        } finally {
            accesoCaja.unlock();
        }    
    }

}
