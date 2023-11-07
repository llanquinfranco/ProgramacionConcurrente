package TP7.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Persona extends Thread {

    private char tipo;
    private Sala sala;

    public Persona(String nombre, char tipo, Sala sala) {
        super(nombre);
        this.tipo = tipo;
        this.sala = sala;
    }

    public void run() {
        try {
            if (tipo == 'J') {
                sala.entrarSalaJubilado();
            } else if (tipo == 'N') {
                sala.entrarSala();
            }
            Thread.sleep(2000);
            sala.salirSala();
        } catch (Exception ex) {

        }
    }

}
