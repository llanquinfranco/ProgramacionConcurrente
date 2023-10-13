package TP3.Ejercicio7Sem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class Impresor implements Runnable {

    private char caracter;
    private int cantidad;
    private Turnos turnos;

    public Impresor(char caracter, int cantidad, Turnos turnos) {
        this.caracter = caracter;
        this.cantidad = cantidad;
        this.turnos = turnos;
    }

    public void run() {
        while (true) {
            try {
                turnos.imprimir(caracter, cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Impresor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
