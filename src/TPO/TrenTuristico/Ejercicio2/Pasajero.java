package TPO.TrenTuristico.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Pasajero extends Thread {

    private int numero;
    private Tren tren;
    private MaquinaTickets maquina;
    private boolean tieneTicket;

    public Pasajero(int numero, Tren tren, MaquinaTickets maquina) {
        this.numero = numero;
        this.tren = tren;
        this.maquina = maquina;
        this.tieneTicket = false;
    }
    

    public void run() {
        try {
            tieneTicket = maquina.comprarTickets();
            if (tieneTicket) {
                tren.subirAlTren(this.numero);
                tren.bajarseDelTren(this.numero);
            } else {
                System.out.println("No asfasfasfdasd");
            }

        } catch (Exception ex) {
        }
    }
}
