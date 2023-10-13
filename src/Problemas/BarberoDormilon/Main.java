package Problemas.BarberoDormilon;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Asiento sillon = new Asiento();
        Barbero barbero = new Barbero(sillon);
        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente(sillon, i);
        }
        barbero.start();
        for (int i = 0; i < 10; i++) {
            clientes[i].start();
        }
    }
}
