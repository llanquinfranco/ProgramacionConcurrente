package TP6.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Pasajero extends Thread {

    private Ferry ferry;
    
    public Pasajero(String nombre, Ferry ferry) {
        super(nombre);
        this.ferry = ferry;
    }
    
    public void run() {
        try {
            ferry.subirPasajero();
            ferry.bajarPasajero();
        } catch(Exception ex) {
            
        }
    }
    
}
