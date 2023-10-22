package TP5.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Torre extends Thread {

    private Pista pista;

    public Torre(Pista pista) {
        this.pista = pista;
    }

    public void run() {
        while (true) {
            try {
                pista.controlar();
            } catch (Exception ex) {

            }
        }
    }

}
