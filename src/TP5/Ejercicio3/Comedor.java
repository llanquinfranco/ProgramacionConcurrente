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
        // Para elegir empezar con perros o con gatos. Cambiar
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
        Thread.sleep(500);
        mutex.acquire();
        usados++;
        cantPerros--;
        mutex.release();
        if (usados == capacidad) {
            // Si comieron la misma cantidad de perros que la cantidad de platos
            if (cantPerros > 0 && cantGatos == 0) {
                // Si no quedan gatos, siguen comiendo los perros (bucle)
                semPerros.release(capacidad);
                usados = 0;
            } else {
                // Si todavia quedan gatos, ahora comen los gatos
                semGatos.release(capacidad);
                usados = 0;
            }
        } else if (cantPerros == 0 && cantGatos > 0) {
            // Si no quedan mas perros, ahora comen los gatos restantes (controlando la cantidad de platos)
            semGatos.release(capacidad);
            usados = 0;
        }

    }

    public void comerGato(int numero) throws InterruptedException {
        semGatos.acquire();
        System.out.println("El gato " + numero + " esta comiendo");
        Thread.sleep(500);
        mutex.acquire();
        usados++;
        cantGatos--;
        mutex.release();
        if (usados == capacidad) {
            // Si comieron la misma cantidad de gatos que la cantidad de platos
            if (cantGatos > 0 && cantPerros == 0) {
                // Si no quedan perros, siguen comiendo los gatos (bucle)
                semGatos.release(capacidad);
                usados = 0;
            } else {
                // Si todavia quedan perros, ahora comen los perros
                semPerros.release(capacidad);
                usados = 0;
            }
        } else if (cantGatos == 0 && cantPerros > 0) {
            // Si no quedan mas gatos, ahora comen los perros restantes (controlando la cantidad de platos)
            semPerros.release(capacidad);
            usados = 0;
        }
    }

}
