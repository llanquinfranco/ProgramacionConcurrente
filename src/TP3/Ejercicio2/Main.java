package TP3.Ejercicio2;

/**
 *
 * @author franco.llanquin
 */
public class Main {

    public static void main(String[] args) {
        Criatura criatura = new Criatura();
        Thread hilo1 = new Thread(criatura, "La Criatura Oscura");
        Thread hilo2 = new Thread(criatura, "El Sanador");
        hilo1.start();
        hilo2.start();
    }
}