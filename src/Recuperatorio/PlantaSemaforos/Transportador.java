package Recuperatorio.PlantaSemaforos;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Transportador extends Thread {

    private Planta planta;
    Random random = new Random();

    public Transportador(Planta planta) {
        this.planta = planta;
    }

    public void run() {
        while (true) {
            try {
                planta.transportar();
            } catch (Exception ex) {

            }
        }
    }

}
