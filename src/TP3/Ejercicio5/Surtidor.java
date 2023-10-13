package TP3.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Surtidor {
    
    private int capacidad = 50;
    
    public Surtidor() {
    }
    
    public int getCapacidadActual() {
        return capacidad;
    }
    
    public void surtir(int cantidad) {
        capacidad = capacidad - cantidad;
    }
}
