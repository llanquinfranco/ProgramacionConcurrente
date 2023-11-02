package TPO.Exposicion;

/**
 *
 * @author Fran
 */
public class Critico extends Thread {

    private Sala sala;

    public Critico(String name, Sala sala) {
        this.sala = sala;
        this.setName(name);
    }

    public void run() {
        try {
            sala.criticar();
            Thread.sleep(600);
        } catch (InterruptedException ex) {
        }
        sala.terminarDeCriticar();
    }
}
