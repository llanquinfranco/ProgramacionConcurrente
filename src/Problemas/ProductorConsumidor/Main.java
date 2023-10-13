package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);

        Productor may = new Productor(buffer, 3, "Maylen Gomez");
        may.start();
        
        Consumidor cayu = new Consumidor(buffer, 2, "Cayu");
        cayu.start();
        
        Productor membrillo = new Productor(buffer, 6, "MorenoCrack");
        membrillo.start();
        
        Consumidor giuli = new Consumidor(buffer, 1, "Giuuuli");
        giuli.start();

    }
}
