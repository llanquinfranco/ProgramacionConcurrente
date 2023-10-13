package TPO.Ejercicio2;

/**
 *
 * @author Fran
 */
public class MaquinaTickets {

    private int cantidad;

    public MaquinaTickets(int cantidad) {
        this.cantidad = cantidad;
    }

    public synchronized boolean comprarTickets() {
        boolean exito = false;
        if (cantidad > 0) {
            cantidad--;
            exito = true;
        }
        return exito;
    }
}
