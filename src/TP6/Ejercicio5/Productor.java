package TP6.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Productor implements Runnable {
    
    private int numero;
    private Buffer buffer;

    public Productor(int numero, Buffer buffer) {
        this.numero = numero;
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.producir(numero);
            } catch (Exception ex) {

            }
        }

    }
}
