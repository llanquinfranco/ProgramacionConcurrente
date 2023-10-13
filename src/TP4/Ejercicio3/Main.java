package TP4.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Proceso proceso = new Proceso();
        Thread p1 = new Thread(proceso, "P1");
        Thread p2 = new Thread(proceso, "P2");
        Thread p3 = new Thread(proceso, "P3");
        p1.start();
        p2.start();
        p3.start();
    }
}