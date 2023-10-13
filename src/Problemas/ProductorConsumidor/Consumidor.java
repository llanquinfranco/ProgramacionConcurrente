package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Consumidor extends Thread {

    private Buffer bufon = new Buffer();

    public Consumidor(Buffer bufon) {
        this.bufon = bufon;
    }

    public void run() {
        while (true) {
            try {
                if (bufon.puedeSacar(3)) {
                    bufon.sacar(3);
                }
            } catch (Exception ex) {
            }
        }

    }
}
