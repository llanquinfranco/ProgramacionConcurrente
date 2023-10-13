package TP3.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Hamaca {

    public synchronized void usarHamaca(int numero) {
        System.out.println("El Hamster " + numero + " esta descansando en la hamaca");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("El Hamster " + numero + " termino de usar la hamaca");
    }
}
