package TP5.Ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Comedor {

    private int capacidad;
    private int usados;
    private int cantPerros;
    private int cantGatos;
    private char especie;
    private Semaphore mutex;
    private Semaphore semGatos;
    private Semaphore semPerros;

    public Comedor(int capacidad, char especie, int cantPerros, int cantGatos) {
        this.capacidad = capacidad;
        this.usados = 0;
        this.mutex = new Semaphore(1);
        if (especie == 'P') {
            semPerros = new Semaphore(capacidad);
            semGatos = new Semaphore(0);
        } else if (especie == 'G') {
            semPerros = new Semaphore(0);
            semGatos = new Semaphore(capacidad);
        }
        this.cantPerros = cantPerros;
        this.cantGatos = cantGatos;
    }

    public void comerPerro(int numero) throws InterruptedException {
        semPerros.acquire();
        
        System.out.println("El perro " + numero + " esta comiendo");
        Thread.sleep(100);
        
        mutex.acquire();
        usados++;
        cantPerros--;
        mutex.release();
        
        System.out.println("Van comiendo " + usados + " perros");
        System.out.println("");
        if (usados == capacidad) {
            semGatos.release(capacidad);
            usados = 0;
        } else if (cantPerros == 0 && cantGatos > 0) {
            semGatos.release(cantGatos);
            usados = 0;
        }
        

    }

    public void comerGato(int numero) throws InterruptedException {
        semGatos.acquire();
        
        System.out.println("El gato " + numero + " esta comiendo");
        Thread.sleep(100);
        
        mutex.acquire();
        usados++;
        cantGatos--;
        mutex.release();
        
        System.out.println("Van comiendo " + usados + " gatos");
        System.out.println("");
        if (usados == capacidad) {
            semPerros.release(capacidad);
            usados = 0;
        } else if (cantGatos == 0 && cantPerros > 0) {
            semPerros.release(cantPerros);
            usados = 0;
        }
        

    }

}
