package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Consumidor extends Thread {

    private Buffer buffer;
    private int cantidad;
    private String nombre;

    public Consumidor(Buffer buffer, int cantidad, String nombre) {
        this.buffer = buffer;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public void run() {
        while (true) {
            try {
                if (buffer.puedeSacar(cantidad)) {
                    buffer.sacar(cantidad, nombre);
                }
            } catch (Exception ex) {
            }
        }

    }
}
