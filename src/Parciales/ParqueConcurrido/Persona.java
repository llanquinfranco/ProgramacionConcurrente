package Parciales.ParqueConcurrido;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Persona extends Thread {
    
    Random random = new Random();
    private boolean esResidente;
    private Parque parque;

    public Persona(String nombre, boolean esResidente, Parque parque) {
        super(nombre);
        this.esResidente = esResidente;
        this.parque = parque;
    }

    public void run() {
        try {
            if (!esResidente) {
                parque.entrarVisitante();
                Thread.sleep(random.nextInt(1000, 2000));
                parque.salirVisitante();
            } else {
                parque.entrarResidente();
                Thread.sleep(random.nextInt(1000, 2000));
                parque.salirResidente();
            }

        } catch (Exception ex) {

        }
    }
}
