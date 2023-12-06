package Parciales.AtomosLocksMonitores;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Oxigeno extends Thread {

    private Recipiente recipiente;
    Random random = new Random();

    public Oxigeno(String nombre, Recipiente recipiente) {
        super(nombre);
        this.recipiente = recipiente;
    }

    public void run() {
        try {
            System.out.println("Oxigeno vagando por el espacio");
            Thread.sleep(random.nextInt(1000, 2000));
            recipiente.Olisto();
        } catch (InterruptedException ex) {
        }
    }

}
