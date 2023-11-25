package Recuperatorio.AtomosSemaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Recipiente {
    
    private Semaphore mutex;
    private int capacidad;
    private int ocupacion;
    private int oxigenos;
    private int hidrogenos;
    
    public Recipiente(int capacidad) {
        this.mutex = new Semaphore(1);
        this.capacidad = capacidad;
        this.ocupacion = 0;
        this.oxigenos = 0;
        this.hidrogenos = 0;
    }
    
    public void Olisto() throws InterruptedException {
        mutex.acquire();
        System.out.println("El " + Thread.currentThread().getName() + " esta listo");
        oxigenos++;
        mutex.release();
        if(hidrogenos >= 2 && oxigenos >= 1) {
            this.hacerAgua();
        }
    }
    
    public void Hlisto() throws InterruptedException {
        mutex.acquire();
        System.out.println("El " + Thread.currentThread().getName() + " esta listo");
        hidrogenos++;
        mutex.release();
        if(hidrogenos >= 2 && oxigenos >= 1) {
            this.hacerAgua();
        }
    }
    
    private void hacerAgua() throws InterruptedException {
        mutex.acquire();
        System.out.println("Se encontraron 2 Hidrogenos y 1 Oxigeno");
        System.out.println("Formando molecula de Agua...");
        Thread.sleep(1000);
        hidrogenos = hidrogenos - 2;
        oxigenos--;
        ocupacion++;
        System.out.println("Se deposito 1 molecula de Agua en el recipiente");
        System.out.println("Recipiente: " + ocupacion + "/" + capacidad);
        if(ocupacion == capacidad) {
            ocupacion = 0;
            System.out.println("El contenido del recipiente fue envasado para su produccion");
            System.out.println("Ahora esta vacio");
        }
        mutex.release();
    }
    
}
