package TP8.Ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class SalaDeEspera {
    
    private int cantCamillas;
    private int camillasUsadas;
    private Semaphore camillas;
    private Semaphore revistas;
    private Semaphore mutex1;
    private Semaphore mutex2;
    
    public SalaDeEspera() {
        this.cantCamillas = 4;
        this.camillasUsadas = 0;
        this.camillas = new Semaphore(4, true);
        this.revistas = new Semaphore(9);
        this.mutex1 = new Semaphore(1);
        this.mutex2 = new Semaphore(1);
    }
    
    public void pedirCamilla() throws InterruptedException {
        
        if(camillasUsadas != cantCamillas) {
            camillas.acquire();
            mutex1.acquire();
            camillasUsadas++;
            System.out.println("El " + Thread.currentThread().getName() + " esta usando la camilla");
            mutex1.release();
        } else {
            revistas.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " esta leyendo una revista");
            camillas.acquire();
            revistas.release();
            mutex1.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " ingreso a una camilla y devolvio una revista");
            camillasUsadas++;
            System.out.println("El " + Thread.currentThread().getName() + " esta usando la camilla");
            mutex1.release();
        }
        
    }
    
    public void soltarCamilla() throws InterruptedException {
        mutex2.acquire();
        System.out.println("El " + Thread.currentThread().getName() + " ya dono sangre y se fue de la sala");
        camillasUsadas--;
        camillas.release();
        mutex2.release();
    }
    
}
