package TP5.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Avion extends Thread {

    private int id;
    private char tipo;
    private Pista pista;

    public Avion(int id, char tipo, Pista pista) {
        this.id = id;
        this.tipo = tipo;
        this.pista = pista;
    }

    public void run() {
        try {
            if (this.tipo == 'A') {
                pista.aterrizar(id);
            } else if (this.tipo == 'D') {
                pista.despegar(id);
            }
        } catch (Exception ex) {

        }
    }

}
