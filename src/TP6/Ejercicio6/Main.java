package TP6.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        int i;
        Buffer buffer = new Buffer(10);
        
        Consumidor[] consumidores = new Consumidor[5];
        for(i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Consumidor(i + 1, buffer);
            Thread hiloConsumidor = new Thread(consumidores[i]);
            hiloConsumidor.start();
        }
        
        Productor[] productores = new Productor[3];
        for(i = 0; i < productores.length; i++) {
            productores[i] = new Productor(i + 1, buffer);
            Thread hiloProductor = new Thread(productores[i]);
            hiloProductor.start();
        }
        
    }
    
}
