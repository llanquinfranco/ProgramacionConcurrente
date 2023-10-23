package TP5.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Tren tren = new Tren(5);
        
        VendedorTickets vendedor = new VendedorTickets(tren); 
        vendedor.start();
        
        ControlTren control = new ControlTren(tren);
        control.start();
        
        Pasajero[] pasajeros = new Pasajero[25];
        for(int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero(i + 1, tren);
            pasajeros[i].start();
        }
    }
    
}
