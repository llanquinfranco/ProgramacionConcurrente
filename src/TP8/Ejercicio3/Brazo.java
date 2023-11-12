package TP8.Ejercicio3;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Brazo extends Thread {
    
    Random random = new Random();
    private Caja caja;

    public Brazo(Caja caja) {
        this.caja = caja;
    }

    public void run() {
        while (true) {
            try {
                caja.retirarCaja();
                Thread.sleep(random.nextInt(1000, 2000));
                caja.reponerCaja();
            } catch (Exception ex) {

            }
        }

    }
}
