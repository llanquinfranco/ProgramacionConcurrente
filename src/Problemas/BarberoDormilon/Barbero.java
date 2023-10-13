package Problemas.BarberoDormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class Barbero extends Thread {

    private Asiento sillon;

    public Barbero(Asiento sillon) {
        this.sillon = sillon;
    }

    public void run() {
        int i = 0;
        try {
            while (i < 10) {
                System.out.println("Barbero esperando en el sillon");
                sillon.dormirBarbero();
                System.out.println("Barbero atendiendo");
                Thread.sleep(500);
                System.out.println("Barbero termino de atender al cliente");
                sillon.terminaDeAtender();
                System.out.println("Esperando a clientes");
                i++;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El Barbero ya cerro");
    }
}
