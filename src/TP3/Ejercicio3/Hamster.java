package TP3.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Hamster implements Runnable {

    private final int numero;
    private final Jaula jaula;

    public Hamster(int numero, Jaula jaula) {
        this.numero = numero;
        this.jaula = jaula;
    }

    public void run() {
        try {
            jaula.comer(this.numero);
            jaula.correr(this.numero);
            jaula.dormir(this.numero);
        } catch (Exception ex) {
        }
        System.out.println("El Hamster " + numero + " termino las 3 actividades");
    }
}