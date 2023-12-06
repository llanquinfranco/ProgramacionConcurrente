package Parciales.AtomosSemaforos;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Hidrogeno extends Thread {
    
    private Recipiente recipiente;
    Random random = new Random();
    
    public Hidrogeno(String nombre, Recipiente recipiente) {
        super(nombre);
        this.recipiente = recipiente;
    }
    
    public void run() {
        try {
            System.out.println("Hidrogeno vagando por el espacio");
            Thread.sleep(random.nextInt(1000,2000));
            recipiente.Hlisto();
        } catch (InterruptedException ex) {
        }
    }
    
}
