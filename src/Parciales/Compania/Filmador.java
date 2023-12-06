package Parciales.Compania;

import java.util.Random;

/**
 *
 * @author franco.llanquin
 */
public class Filmador extends Thread {
    
    Random r = new Random();
    private Compania compania;
    
    public Filmador(Compania compania) {
        this.compania = compania;
    }
    
    public void run() {
        while(true) {
            try {
                Thread.sleep(3000); // simula tiempo de filmacion
                compania.filmarCapitulo();
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
