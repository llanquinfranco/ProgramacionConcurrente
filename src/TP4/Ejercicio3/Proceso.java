package TP4.Ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class Proceso implements Runnable{
    Turnos turno = new Turnos(); // Recurso compartido ¿?, contador i
    
    public void run() {
        int i = 0;
        while(i < 5) {
            try {
                turno.ejecutar();
                i++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}