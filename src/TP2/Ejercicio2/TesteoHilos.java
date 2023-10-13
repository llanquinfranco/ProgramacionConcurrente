package TP2.Ejercicio2;

/**
 *
 * @author Fran
 */
public class TesteoHilos {

    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        try{
            miHilo.join();
        } catch(Exception ex) {
        }
        System.out.println("En el main");
    }
}
