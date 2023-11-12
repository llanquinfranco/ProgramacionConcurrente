package TP8.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        
        Mostrador mostrador = new Mostrador();
        Caja caja = new Caja(100);
        
        Brazo brazo = new Brazo(caja);
        brazo.start();
        
        Empaquetador empaquetador1 = new Empaquetador("Empaquetador 1", mostrador, caja);
        Empaquetador empaquetador2 = new Empaquetador("Empaquetador 2", mostrador, caja);
        empaquetador1.start();
        empaquetador2.start();
        
        Horno hornoA = new Horno('A', mostrador);
        Horno hornoB = new Horno('B', mostrador);
        Horno hornoC = new Horno('C', mostrador);
        hornoA.start();
        hornoB.start();
        hornoC.start();
        
    }
    
}
