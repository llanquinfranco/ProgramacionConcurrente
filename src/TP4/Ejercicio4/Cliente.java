package TP4.Ejercicio4;

/**
 *
 * @author Fran
 */
public class Cliente extends Thread {

    int numero;
    GestorImpresoras gestor;

    public Cliente(int numero, GestorImpresoras gestor) {
        this.numero = numero;
        this.gestor = gestor;
    }

    public void run() {
        try {
            gestor.buscar(numero);
        } catch (InterruptedException ex) {
        }
        System.out.println(numero + " TERMINEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
    }
}
