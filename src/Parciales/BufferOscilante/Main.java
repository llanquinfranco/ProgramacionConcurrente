package Parciales.BufferOscilante;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        
        for(int i = 1; i < 11; i++) {
            Extractor extractor = new Extractor("Extractor " + i, buffer);
            extractor.start();
        }
        
        for(int j = 1; j < 11; j++) {
            Insertor insertor = new Insertor("Insertor " + j, buffer);
            insertor.start();
        }
    }
    
}
