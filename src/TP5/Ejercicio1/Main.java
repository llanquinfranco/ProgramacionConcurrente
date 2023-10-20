package TP5.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Piscina piscina = new Piscina(5);
        
        GestorPiscina gestor = new GestorPiscina(piscina);
        
        Persona[] personas = new Persona[20];
        for(int i = 0; i < personas.length; i++) {
            personas[i] = new Persona(i + 1, gestor);
            personas[i].start();
        }
        
        
    }
    
}
