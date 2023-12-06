package Parciales.PlantaSemaforos;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Empaquetador extends Thread {

    private Planta planta;
    Random random = new Random();

    public Empaquetador(Planta planta) {
        this.planta = planta;
    }

    public void run() {
        while (true) {
            try {
                planta.retirarCaja();
                Thread.sleep(random.nextInt(1000, 2000));
                planta.reponerCaja();
            } catch (Exception ex) {

            }
        }
    }

}
