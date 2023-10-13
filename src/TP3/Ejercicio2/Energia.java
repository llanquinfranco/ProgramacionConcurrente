package TP3.Ejercicio2;

/**
 *
 * @author franco.llanquin
 */
public class Energia {
    
    private int unidades = 10;
    
    public Energia() {
    }

    public int getEnergia() {
        return unidades;
    }
    
    public void drenar(){
        unidades = unidades - 3;
    }
    
    public void revitalizar(){
        unidades = unidades + 3;
    }
}