package TP6.Ejercicio7;

/**
 *
 * @author Fran
 */
public class ControlFerry extends Thread {

    private Ferry ferry;

    public ControlFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    public void run() {
        while (true) {
            try {
                ferry.iniciarRecorrido();
                Thread.sleep(2000);     //Sleep en la clase hilo y no en el RC
                ferry.finalizarRecorrido();
            } catch (Exception ex) {

            }
        }
    }

}
