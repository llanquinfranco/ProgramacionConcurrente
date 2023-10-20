package TP5.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Persona extends Thread {

    private int numero;
    private GestorPiscina gestor;

    public Persona(int numero, GestorPiscina gestor) {
        this.numero = numero;
        this.gestor = gestor;
    }

    public void run() {
        try {
            gestor.nadar(numero);
        } catch (Exception ex) {

        }
    }

}
