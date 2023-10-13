package TP4.Ejercicio1;

/**
 *
 * @author Fran
 */
public class SynchronizedObjectCounter {

    private int c = 0;

    public void increment() {
        synchronized ((Integer)c) {
            c++;
        } // Este elemento debe ser casteado a Integer
    }

    public void decrement() {
        synchronized (this) {
            c--;
        }
    }

    public int value() {
        return c;
    }
}