package TP4.Ejercicio4;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        GestorImpresoras gestor = new GestorImpresoras();
        Cliente[] clientes = new Cliente[20];
        int i;
        for (i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente((i + 1), gestor);
        }
        for (i = 0; i < clientes.length; i++) {
            clientes[i].start();
        }
    }
}
