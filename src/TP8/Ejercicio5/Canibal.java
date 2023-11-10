package TP8.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Canibal extends Thread {

    private Olla olla;

    public Canibal(String nombre, Olla olla) {
        super(nombre);
        this.olla = olla;
    }

    public void run() {
        try {
            olla.comer();
        } catch (Exception ex) {

        }
    }

}
