package TP4.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        int i;
        Taxi taxi = new Taxi();
        Taxista taxista = new Taxista(taxi);
        Cliente[] clientes = new Cliente[10];
        
        for(i = 0; i < clientes.length; i++) {
            Cliente cliente = new Cliente(i + 1, taxi);
            clientes[i] = cliente;
            clientes[i].start();
        }
        
        taxista.start();
    }
}
