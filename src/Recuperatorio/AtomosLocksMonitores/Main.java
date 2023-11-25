package Recuperatorio.AtomosLocksMonitores;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Recipiente recipiente = new Recipiente(10);

        Generador generador = new Generador(recipiente);
        generador.start();
    }
    
}
