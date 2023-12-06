package Parciales.Compania;

import java.util.Random;

/**
 *
 * @author franco.llanquin
 */
public class Traductor extends Thread {
    
    Random r = new Random();
    private Compania compania;
    
    public Traductor(String nombre, Compania compania) {
        super(nombre);
        this.compania = compania;
    }
    
    public void run() {
        while(true) {
            try {
                Thread.sleep(6000); // simula tiempo de traduccion
                compania.traducirCapitulo();
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
