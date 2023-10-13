package TP4.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Cliente extends Thread {

    private int numero;
    private char tipo;
    private GestorImpresoras gestor;

    public Cliente(int numero, char tipo, GestorImpresoras gestor) {
        this.numero = numero;
        this.tipo = tipo;
        this.gestor = gestor;
    }

    public void run() {
        try {
            gestor.buscar(numero, tipo);
        } catch (InterruptedException ex) {
        }
        System.out.println(numero + " TERMINEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
    }
}
