package TP3.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Main {
    
    public static void main(String[] args) {
        Jaula jaula = new Jaula();
        Hamster hamster1 = new Hamster(1, jaula);
        Hamster hamster2 = new Hamster(2, jaula);
        Hamster hamster3 = new Hamster(3, jaula);
        Thread hilo1 = new Thread(hamster1);
        Thread hilo2 = new Thread(hamster2);
        Thread hilo3 = new Thread(hamster3);
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}