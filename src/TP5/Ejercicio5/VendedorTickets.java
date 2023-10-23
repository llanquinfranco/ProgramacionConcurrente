package TP5.Ejercicio5;

/**
 *
 * @author Fran
 */
public class VendedorTickets extends Thread {

    private Tren tren;

    public VendedorTickets(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        while (true) {
            try {
                tren.venderTicket();
            } catch (Exception ex) {
            }
        }
    }
}
