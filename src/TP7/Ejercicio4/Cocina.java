package TP7.Ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Cocina {

    private int carne;
    private int vegetales;
    private int pasta;
    private Semaphore semCarne;
    private Semaphore semVegetales;
    private Semaphore semPasta;

    public Cocina() {
        this.carne = 3;
        this.vegetales = 3;     // La cocina tiene 3 ingredientes de cada uno
        this.pasta = 3;
        this.semCarne = new Semaphore(3);
        this.semVegetales = new Semaphore(3);   // Hace falta mutex¿? creo q no
        this.semPasta = new Semaphore(3);
    }

    public void cocinarCarne() throws InterruptedException {
        semCarne.acquire();
        carne--;
        System.out.println("El " + Thread.currentThread().getName() + " tomo un pedazo de carne del deposito");
        System.out.println("Carne disponible: " + carne);
        System.out.println(Thread.currentThread().getName() + " cocinando carne a la parrilla...");
    }

    public void reponerCarne() {
        System.out.println(Thread.currentThread().getName() + " termino de cocinar carne a la parrilla");
        carne++;
        System.out.println("El " + Thread.currentThread().getName() + " repuso un pedazo de carne en el deposito");
        System.out.println("Carne disponible: " + carne);
        semCarne.release();
    }

    public void cocinarEnsalada() throws InterruptedException {
        semVegetales.acquire();
        vegetales--;
        System.out.println("El " + Thread.currentThread().getName() + " tomo un vegetal del deposito");
        System.out.println("Vegetales disponibles: " + vegetales);
        System.out.println(Thread.currentThread().getName() + " cocinando ensalada de vegetales...");
    }

    public void reponerVegetales() {
        System.out.println(Thread.currentThread().getName() + " termino de cocinar ensalada de vegetales");
        vegetales++;
        System.out.println("El " + Thread.currentThread().getName() + " repuso un vegetal en el deposito");
        System.out.println("Vegetales disponibles: " + vegetales);
        semVegetales.release();
    }

    public void cocinarPasta() throws InterruptedException {
        semPasta.acquire();
        pasta--;
        System.out.println("El " + Thread.currentThread().getName() + " tomo una pasta del deposito");
        System.out.println("Pastas disponibles: " + pasta);
        System.out.println(Thread.currentThread().getName() + " cocinando pasta al pesto...");
    }

    public void reponerPasta() {
        System.out.println(Thread.currentThread().getName() + " termino de cocinar pasta al pesto");
        pasta++;
        System.out.println("El " + Thread.currentThread().getName() + " repuso una pasta en el deposito");
        System.out.println("Pastas disponibles: " + pasta);
        semPasta.release();
    }
}
