package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Consumidor extends Thread {

    private Buffer bufon;
    private int cantidad;
    private String nombre;
    public Consumidor(Buffer bufon,int cantidad,String nombre) {
        this.bufon = bufon;
        this.cantidad=cantidad;
        this.nombre= nombre;
    }

    public void run() {
        while (true) {
            try {
                if (bufon.puedeSacar(cantidad)) {
                    bufon.sacar(cantidad,nombre);
                }
            } catch (Exception ex) {
            }
        }

    }
}
