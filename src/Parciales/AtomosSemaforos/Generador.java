package Parciales.AtomosSemaforos;

/**
 *
 * @author Fran
 */
public class Generador extends Thread {

    private Recipiente recipiente;

    public Generador(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    public void run() {
        int i = 1;
        while (true) {
            try {
                Thread.sleep(500);
                Oxigeno oxigeno = new Oxigeno("Oxigeno " + i, recipiente);
                oxigeno.start();
                Thread.sleep(500);
                Hidrogeno hidrogeno = new Hidrogeno("Hidrogeno " + i, recipiente);
                hidrogeno.start();
                i++;
            } catch (Exception ex) {

            }
        }

    }

}
