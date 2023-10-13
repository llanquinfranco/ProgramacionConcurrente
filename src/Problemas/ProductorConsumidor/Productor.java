package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Productor extends Thread{

    private Buffer bufon = new Buffer();

    public Productor(Buffer bufon) {
        this.bufon = bufon;
    }

    public void run() {
        while(true) {
            try {
                if (bufon.puedeAgregar(3)) {
                    bufon.agregar(3);
                }
            } catch (Exception ex) {
            }
        }
        
    }

}
