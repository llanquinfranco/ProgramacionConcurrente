package TP7.Ejercicio1;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Medidor extends Thread {

    private Sala sala;

    public Medidor(Sala sala) {
        this.sala = sala;
    }

    public void run() {
        Random random = new Random();
        while (true) {
            try {
                int temperatura = random.nextInt(20, 40);
                sala.notificarTemperatura(temperatura);
                Thread.sleep(1500);
            } catch (Exception ex) {

            }
        }
    }
}
