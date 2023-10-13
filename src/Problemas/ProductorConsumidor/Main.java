package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Buffer bufon = new Buffer();
        
        Productor metroooo = new Productor(bufon);
        metroooo.start();
        Consumidor cayu = new Consumidor(bufon);
        cayu.start();
    }
    
}
