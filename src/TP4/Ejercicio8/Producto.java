package TP4.Ejercicio8;

/**
 *
 * @author Fran
 */
public class Producto extends Thread {

    private int numero;
    private char tipo;
    private ControladorProduccion controlador;

    public Producto(int numero, char tipo, ControladorProduccion controlador) {
        this.numero = numero;
        this.tipo = tipo;
        this.controlador = controlador;
    }

    public void run() {
        try {
            if (this.tipo == 'E') {
                controlador.llegaElectrico(this.numero);
            } else if (this.tipo == 'M') {
                controlador.llegaMecanico(this.numero);
            }
        } catch (Exception ex) {
        }
    }
}
