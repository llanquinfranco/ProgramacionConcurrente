package Recuperatorio.PlantaLocksMonitores;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        
        Planta planta = new Planta();
        
        Empaquetador empaquetador = new Empaquetador(planta);
        empaquetador.start();
        
        Transportador transportador = new Transportador(planta);
        transportador.start();
        
        Embotellador emboVino = new Embotellador("Embotellador Vino", 'V', planta);
        emboVino.start();
        
        Embotellador emboAgua = new Embotellador("Embotellador Agua", 'A', planta);
        emboAgua.start();
        
        
    }
    
}
