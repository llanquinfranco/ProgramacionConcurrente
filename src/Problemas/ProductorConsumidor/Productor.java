package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Productor extends Thread {

    private Buffer buffer;
    private int cantidad;
    private String nombre;

    public Productor(Buffer buffer, int cantidad, String nombre) {
        this.buffer = buffer;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public void run() {
        while (true) {
            try {
                if (buffer.puedeAgregar(cantidad)) {
                    buffer.agregar(cantidad, nombre);
                }
            } catch (Exception ex) {
            }
        }
    }

}
