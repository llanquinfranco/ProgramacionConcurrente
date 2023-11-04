package TP6.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Automovil extends Thread {

    private int capacidad;
    private Ferry ferry;

    public Automovil(String nombre, int capacidad, Ferry ferry) {
        super(nombre);
        this.capacidad = capacidad;
        this.ferry = ferry;
    }

    public void run() {
        try {
            ferry.subirAutomovil(capacidad);
            ferry.bajarAutomovil(capacidad);
        } catch (Exception ex) {

        }

    }

}
