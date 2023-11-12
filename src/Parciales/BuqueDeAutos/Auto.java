package Parciales.BuqueDeAutos;

/**
 *
 * @author Fran
 */
public class Auto extends Thread {

    private Buque buque;

    public Auto(String nombre, Buque buque) {
        super(nombre);
        this.buque = buque;
    }

    public void run() {
        try {
            buque.entrar();
            buque.salir();
        } catch (Exception ex) {

        }

    }
}
