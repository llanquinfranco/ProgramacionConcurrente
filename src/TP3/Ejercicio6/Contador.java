package TP3.Ejercicio6;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Contador extends Thread {

    private final String nombre;
    private final int inicio;
    private final int fin;

    private static final Dato dato = new Dato();
    private static final int[] numeros = new int[50000];

    public Contador(String nombre, int inicio, int fin) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run() {
        int i, cantidad, j = 0;
        for (i = this.inicio; i < this.fin; i++) {
            cantidad = numeros[i];
            j = j + numeros[i];
            dato.sumar(cantidad);
        }
        System.out.println("Suma parcial del " + this.nombre + ": " + j);
    }

    public static void main(String[] args) {
        Contador[] hilos = new Contador[10];
        int i, inicio = 0, rango = numeros.length / hilos.length, fin = rango;
        Random random = new Random();
        
        for (i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(10) + 1;
        }

        for (i = 0; i < hilos.length; i++) {
            if (i != hilos.length - 1) {
                Contador hilo = new Contador("Hilo " + (i + 1), inicio, fin);
                hilos[i] = hilo;
                hilos[i].start();
                inicio = fin;
                fin = fin + rango;
            } else {
                Contador hilo = new Contador("Hilo " + (i + 1), inicio, numeros.length);
                hilos[i] = hilo;
                hilos[i].start();
            }
        }

        try {
            for (i = 0; i < numeros.length; i++) {
                hilos[i].join();
            }
        } catch (Exception ex) {
        }
        System.out.println("Suma total: " + dato.obtenerSuma());
    }

}
