package Parciales.PlantaSemaforos;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Embotellador extends Thread {

    private char tipo;
    private Planta planta;
    Random random = new Random();

    public Embotellador(String nombre, char tipo, Planta planta) {
        super(nombre);
        this.tipo = tipo;
        this.planta = planta;
    }

    public void run() {
        while (true) {
            try {
                if(tipo == 'A') {
                    Thread.sleep(random.nextInt(1000,2000));
                    planta.prepararBotellaAgua();
                } else if(tipo == 'V') {
                    Thread.sleep(random.nextInt(1000,2000));
                    planta.prepararBotellaVino();
                }
            } catch (Exception ex) {

            }

        }
    }

}
