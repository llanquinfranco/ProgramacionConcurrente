package TP4.Ejercicio8;

/**
 *
 * @author Fran
 */
public class Control extends Thread {

    private ControladorProduccion controlador;

    public Control(ControladorProduccion controlador) {
        this.controlador = controlador;
    }
    
    public void run() {
        while(true) {
            try {
                controlador.cambiaLineas();
                Thread.sleep(60);
            }catch(Exception ex) {
            }
        }
    }
}
