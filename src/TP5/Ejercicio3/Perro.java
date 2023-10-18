package TP5.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Perro extends Thread {

    private int numero;
    private Comedor comedor;

    public Perro(int numero, Comedor comedor) {
        this.numero = numero;
        this.comedor = comedor;
    }

    public void run() {
        try {
            comedor.comerPerro(this.numero);
        } catch (Exception ex) {

        }
    }

}
