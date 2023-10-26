package TP5.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Encargado extends Thread {

    private Mirador mirador;

    public Encargado(Mirador mirador) {
        this.mirador = mirador;
    }

    public void run() {
        try {
            while (true) {
                mirador.hacerBajar();
            }
        } catch (Exception ex) {

        }
    }

}
