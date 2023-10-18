package TP5.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Gato extends Thread {

    private int numero;
    private Comedor comedor;

    public Gato(int numero, Comedor comedor) {
        this.numero = numero;
        this.comedor = comedor;
    }

    public void run() {
        try {
            comedor.comerGato(this.numero);
        } catch (Exception ex) {

        }
    }

}
