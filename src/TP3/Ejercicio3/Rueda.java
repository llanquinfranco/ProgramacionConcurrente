package TP3.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Rueda {

    public synchronized void usarRueda(int numero) {
        System.out.println("El Hamster " + numero + " esta corriendo en la rueda");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("El Hamster " + numero + " termino de usar la rueda");
    }
}
