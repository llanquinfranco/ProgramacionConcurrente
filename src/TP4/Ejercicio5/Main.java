package TP4.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        GestorImpresoras gestor = new GestorImpresoras(4, 4);
        Cliente[] clientesA = new Cliente[10];
        Cliente[] clientesB = new Cliente[10];
        int i;
        for (i = 0; i < clientesA.length; i++) {
            clientesA[i] = new Cliente((i + 1), 'A', gestor);
        }
        for (i = 0; i < clientesB.length; i++) {
            clientesB[i] = new Cliente((i + 1), 'B', gestor);
        }
        for (i = 0; i < clientesA.length; i++) {
            clientesA[i].start();
        }
        for (i = 0; i < clientesB.length; i++) {
            clientesB[i].start();
        }
    }
}
