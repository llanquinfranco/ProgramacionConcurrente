package TP5.Ejercicio5;

/**
 *
 * @author Fran
 */
public class ControlTren extends Thread {

    private Tren tren;

    public ControlTren(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        while (true) {
            try {
                tren.iniciarRecorrido();
            } catch (Exception ex) {
            }
        }
    }
}
