package TP5.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Persona extends Thread{
    
    private int numero;
    private Piscina piscina;
    
    public Persona(int numero, Piscina piscina) {
        this.numero = numero;
        this.piscina = piscina;
    }
    
    
    public void run() {
        
        piscina.solicitarAcceso();
        
        
        piscina.salirPiscina();
        
        
    }
}
