package TP2.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Cliente {
    
    private final String nombre;
    private final int[] carroCompra;
    
    public Cliente(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int[] getCarroCompra() {
        return carroCompra;
    }
}
