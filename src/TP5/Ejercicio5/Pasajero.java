package TP5.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Pasajero extends Thread {

    private int numero;
    private Tren tren;

    public Pasajero(int numero, Tren tren) {
        this.numero = numero;
        this.tren = tren;
    }

    public void run() {
        try {
            tren.comprarTicket(this.numero);
            tren.subirAlTren(this.numero);
            tren.bajarseDelTren(this.numero);
        } catch (Exception ex) {

        }
    }

}
