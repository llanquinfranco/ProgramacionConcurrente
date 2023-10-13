package TP2.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Recurso {

    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("en Recurso: Soy" + t.getName());
    }
}
