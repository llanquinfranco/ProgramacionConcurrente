package TP8.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Cocinero extends Thread {

    private Olla olla;

    public Cocinero(Olla olla) {
        this.olla = olla;
    }

    public void run() {
        while (true) {
            try {
                olla.cocinar();
            } catch (Exception ex) {

            }
        }

    }

}
