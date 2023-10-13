package TP2.Ejercicio8;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Corredor implements Runnable {
    /* Crea una clase llamada Corredor que serán los hilos. Dentro de esta 
    clase, define los atributos necesarios como el nombre del corredor y la 
    distancia recorrida. Cada corredor sabe la distancia que recorrió, por lo
    que deberá imprimir su nombre y el avance (aleatorio entre 1 y 10), por 
    cada paso que realiza. Entre cada paso realizado descansa. Una vez que haga
    100 pasos, el corredor habrá terminado */
    private final String nombre;
    private int distancia;

    public Corredor(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getDistancia() {
        return distancia;
    }

    public void run() {
        /* Utiliza Thread.sleep() dentro del metodo run() de cada corredor
        para simular el tiempo entre pasos */
        Random random = new Random();
        int pasos = 0;
        while (pasos <= 100) {
            try {
                int avance = random.nextInt(10) + 1;
                this.distancia = this.distancia + avance;
                System.out.println("El " + this.nombre + " lleva recorrido " + this.distancia + "m");
                Thread.sleep(100);
                pasos++;
            } catch (InterruptedException exc) {
                System.out.println("Corredor interrumpido?");
            }
        }
    }
}
