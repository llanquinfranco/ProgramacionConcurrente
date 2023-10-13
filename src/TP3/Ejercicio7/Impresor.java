package TP3.Ejercicio7;

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
            } catch (Exception ex) {
            }
        }
    }
}
