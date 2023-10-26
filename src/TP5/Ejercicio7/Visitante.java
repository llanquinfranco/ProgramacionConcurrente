package TP5.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Visitante extends Thread {

    private int numero;
    private Mirador mirador;

    public Visitante(int numero, Mirador mirador) {
        this.numero = numero;
        this.mirador = mirador;
    }

    public void run() {
        try {
            mirador.subirAlMirador(numero);
            mirador.bajarPorTobogan(numero);
        } catch (Exception ex) {

        }
    }

}
