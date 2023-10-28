package TP6.Ejercicio4;

/**
 *
 * @author Fran
 */
public class Productor implements Runnable {

    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.producir();
            } catch (Exception ex) {

            }
        }

    }
}
