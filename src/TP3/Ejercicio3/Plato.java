package TP3.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Plato {

    public synchronized void usarPlato(int numero) {
        System.out.println("El Hamster " + numero + " esta comiendo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("El Hamster " + numero + " termino de comer");
    }

}
