package Parciales.BuqueDeAutos;

/**
 *
 * @author Fran
 */
public class ControlBuque extends Thread {
    
    private Buque buque;
    
    public ControlBuque(Buque buque) {
        this.buque = buque;
    }
    
    public void run() {
        while (true) {
            try {
                buque.ir();
                buque.volver();
            } catch (Exception ex) {

            }
        }

    }
}
