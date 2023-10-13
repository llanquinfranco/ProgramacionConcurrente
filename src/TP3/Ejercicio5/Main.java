package TP3.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Auto[] autos = new Auto[5];
        int i;
        
        for(i = 0; i < autos.length; i++) {
            Auto auto = new Auto("Auto " + i, 100);
            autos[i] = auto;
        }
        
        for(i = 0; i < autos.length; i++) {
            autos[i].start();
        }
        
        
    }
    
}
