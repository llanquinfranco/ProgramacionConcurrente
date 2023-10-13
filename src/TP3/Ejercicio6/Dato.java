package TP3.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Dato {

    private int valor = 0;

    public synchronized void sumar(int cantidad) {
        valor = valor + cantidad;
    }

    public synchronized int obtenerSuma() {
        return valor;
    }
}
