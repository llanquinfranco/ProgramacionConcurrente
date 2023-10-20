package TP5.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Cocinero extends Thread {

    private Confiteria confiteria;

    public Cocinero(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        while (true) {
            try {
                confiteria.prepararComida();
                
                
                confiteria.servirComida();
            } catch (Exception ex) {

            }
        }
    }
}
