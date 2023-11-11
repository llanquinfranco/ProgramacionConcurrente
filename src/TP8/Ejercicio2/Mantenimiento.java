package TP8.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Mantenimiento extends Thread {

    private Observatorio observatorio;

    public Mantenimiento(String nombre, Observatorio observatorio) {
        super(nombre);
        this.observatorio = observatorio;
    }

    public void run() {
        try {
            observatorio.entrarMantenimiento();
            //Thread.sleep(3000);
            observatorio.salirMantenimiento();
        } catch (Exception ex) {

        }
    }
}
