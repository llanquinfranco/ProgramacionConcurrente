package Problemas.BarberoDormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class Cliente extends Thread {

    private Asiento sillon;
    private int numero;

    public Cliente(Asiento sillon, int numero) {
        this.sillon = sillon;
        this.numero = numero;
    }

    public void run() {
        try {
            sillon.ocuparSillon();
            System.out.println("Cliente " + (numero + 1) + " verificando si esta libre el sillon");
            sillon.despertarBarbero();
            System.out.println("Cliente " + (numero + 1) + " solicitando atencion al barbero");
            sillon.cortarElPelo();
            Thread.sleep(500);
            System.out.println("Cliente " + (numero + 1) + " espera mientras lo atienden");
            sillon.liberarSillon();
            System.out.println("Cliente " + (numero + 1) + " libera el sillon");
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
