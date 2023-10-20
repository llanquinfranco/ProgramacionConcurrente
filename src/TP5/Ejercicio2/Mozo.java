package TP5.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Mozo extends Thread {

    private Confiteria confiteria;

    public Mozo(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        while (true) {
            try {
                confiteria.prepararBebida();
                
                
                
                
                confiteria.servirBebida();
            } catch (Exception ex) {
            }
        }
    }

}
