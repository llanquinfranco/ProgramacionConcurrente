package Recuperatorio.AtomosSemaforos;

/**
 *
 * @author Fran
 */
public class ControlRecipiente extends Thread {

    private Recipiente recipiente;

    public ControlRecipiente(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    public void run() {
        while (true) {
            try {
                recipiente.hacerAgua();
            } catch (Exception ex) {
            }
        }
    }

}