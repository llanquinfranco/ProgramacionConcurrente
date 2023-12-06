package Parciales.AtomosLocksMonitores;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Recipiente recipiente = new Recipiente(10);
        
        ControlRecipiente control = new ControlRecipiente(recipiente);
        control.start();
        
        Generador generador = new Generador(recipiente);
        generador.start();
    }
    
}
