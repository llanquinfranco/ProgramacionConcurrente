package TP6.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Consumidor implements Runnable {

    private int numero;
    private Buffer buffer;

    public Consumidor(int numero, Buffer buffer) {
        this.numero = numero;
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.consumir(numero);
            } catch (Exception ex) {

            }
        }
    }

}
