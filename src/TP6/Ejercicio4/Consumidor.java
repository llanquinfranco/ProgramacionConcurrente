package TP6.Ejercicio4;

/**
 *
 * @author Fran
 */
public class Consumidor implements Runnable {

    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.consumir();
            } catch (Exception ex) {

            }
        }
    }

}
