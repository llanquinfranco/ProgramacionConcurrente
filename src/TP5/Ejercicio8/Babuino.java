package TP5.Ejercicio8;

/**
 *
 * @author Fran
 */
public class Babuino extends Thread {

    private int numero;
    private char lado;  // En que lado del cañon se encuentra el babuino ('I' o 'D')
    private Cuerda cuerda;

    public Babuino(int numero, char lado, Cuerda cuerda) {
        this.numero = numero;
        this.lado = lado;
        this.cuerda = cuerda;
    }

    public void run() {
        try {
            if (lado == 'I') {
                // Si esta del lado izquierdo, debe cruzar al lado derecho
                cuerda.cruzarHaciaLaDerecha(numero);
            } else if (lado == 'D') {
                // Si esta del lado derecho, debe cruzar al lado izquierdo
                cuerda.cruzarHaciaLaIzquierda(numero);
            }
        } catch (Exception ex) {

        }

    }

}
