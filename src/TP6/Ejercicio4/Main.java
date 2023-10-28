package TP6.Ejercicio4;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        
        Consumidor consumidor = new Consumidor(buffer);
        Thread hiloConsumidor = new Thread(consumidor);
        hiloConsumidor.start();
        
        Productor productor = new Productor(buffer);
        Thread hiloProductor = new Thread(productor);
        hiloProductor.start();
        
    }
    
}
