package TP5.Ejercicio1;

/**
 *
 * @author Fran
 */
public class GestorPiscina {
    
    private Piscina piscina;
    
    public void GestorPiscina(Piscina piscina) {
        this.piscina = piscina;
    }
    
    
    public void run() {
        while(true) {
            
            piscina.dejarEntrar();
            
            
            piscina.liberarLugar();
            
        }
    }
    
}
