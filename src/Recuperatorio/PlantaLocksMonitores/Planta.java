package Recuperatorio.PlantaLocksMonitores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Planta {
    
    private int cajaAgua;
    private int cajaVino;
    private int almacen;
    private boolean hayCajaAgua;
    private boolean hayCajaVino;
    private Lock accesoAgua;
    private Lock accesoVino;
    private Lock accesoAlmacen;
    private Condition empaquetador;
    private Condition transportador;
    private Condition embotelladoresAgua;
    private Condition embotelladoresVino;
    
    public Planta() {
        this.cajaAgua = 0;
        this.cajaVino = 0;
        this.almacen = 0;
        this.hayCajaAgua = true;
        this.hayCajaVino = true;
        this.accesoAgua = new ReentrantLock();
        this.accesoVino = new ReentrantLock();
        this.accesoAlmacen = new ReentrantLock();
        this.empaquetador = accesoAlmacen.newCondition();
        this.transportador = accesoAlmacen.newCondition();
        this.embotelladoresAgua = accesoAgua.newCondition();
        this.embotelladoresVino = accesoVino.newCondition();
    }
    
    
    public void prepararBotellaAgua() throws InterruptedException {
        try {
            accesoAgua.lock();
            while(cajaAgua == 10 || !hayCajaAgua) {
                embotelladoresAgua.await();
            }
            cajaAgua++;
            System.out.println("El " + Thread.currentThread().getName() + " ubico"
                    + " una botella de agua saborizada en la caja");
            System.out.println("Caja de agua saborizada: " + cajaAgua + "/ 10");
            if(cajaAgua == 10) {
                empaquetador.signal();
            }
        } finally {
            accesoAgua.unlock();
        }
        
        
    }
    
    public void prepararBotellaVino() throws InterruptedException {
        try {
            accesoVino.lock();
            while(cajaVino == 10 || !hayCajaVino) {
                embotelladoresVino.await();
            }
            cajaVino++;
            System.out.println("El " + Thread.currentThread().getName() + " ubico"
                    + " una botella de vino en la caja");
            System.out.println("Caja de vino: " + cajaVino + "/ 10");
            if(cajaVino == 10) {
                empaquetador.signal();
            }
        } finally {
            accesoVino.unlock();
        }
        
        
    }
    
    public void retirarCaja() throws InterruptedException {
        try {
            accesoAlmacen.lock();
            while(cajaAgua < 10 && cajaVino < 10) {
                empaquetador.await();
            }
            if(cajaAgua == 10) {
                System.out.println("Se lleno la caja de agua saborizada y el empaquetador la retiro");
                hayCajaAgua = false;
                System.out.println("La caja de agua se guardo en el deposito");
                almacen++;
                if(almacen == 10) {
                    transportador.signal();
                }
            } else if(cajaVino == 10){
                System.out.println("Se lleno la caja de vino y el empaquetador la retiro");
                hayCajaVino = false;
                System.out.println("La caja de vino se guardo en el deposito");
                almacen++;
                if(almacen == 10) {
                    transportador.signal();
                }
            }
        } finally {
            accesoAlmacen.unlock();
        }
    }
    
    public void reponerCaja() {
        try {
            accesoAlmacen.lock();
            if(!hayCajaAgua) {
                cajaAgua = 0;
                hayCajaAgua = true;
                System.out.println("Se repuso la caja de agua");
                embotelladoresAgua.signalAll();
            } else if(!hayCajaVino) {
                cajaVino = 0;
                hayCajaVino = true;
                System.out.println("Se repuso la caja de vino");
                embotelladoresVino.signalAll();
            }
        } finally {
            accesoAlmacen.unlock();
        }
    }
    
    public void transportar() throws InterruptedException {
        try {
            accesoAlmacen.lock();
            while(almacen < 10) {
                transportador.await();
            }
            System.out.println("El almacen se lleno, un camion salio a repatir"
                    + " todo el contenido del almacen");
            almacen = 0;
            empaquetador.signal();
        } finally {
            accesoAlmacen.unlock();
        }
    }
}
