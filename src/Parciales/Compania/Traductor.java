package Parciales.Compania;

/**
 *
 * @author Fran
 */
public class Traductor extends Thread {
    
    private Compania compania;
    
    public Traductor(String nombre, Compania compania) {
        super(nombre);
        this.compania = compania;
    }
    
    public void run() {
        while(true) {
            try {
                Thread.sleep(1500);
                compania.traducirCapitulo();
            } catch (InterruptedException ex) {
            }
        }
    }
}
