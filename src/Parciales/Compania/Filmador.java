package Parciales.Compania;

/**
 *
 * @author Fran
 */
public class Filmador extends Thread {
    
    private Compania compania;
    
    public Filmador(Compania compania) {
        this.compania = compania;
    }
    
    public void run() {
        while(true) {
            try {
                Thread.sleep(2000);
                compania.filmarCapitulo();
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
