package TP5.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Empleado extends Thread {

    private int numero;
    private int tipo;
    private Confiteria confiteria;

    public Empleado(int numero, int tipo, Confiteria confiteria) {
        this.numero = numero;
        this.tipo = tipo;
        this.confiteria = confiteria;
    }

    public void run() {
        try {
            confiteria.ocuparEspacio(numero);
            switch (tipo) {
                case 1:
                    confiteria.pedirBebida(numero);
                    confiteria.tomar(numero);
                    break;
                case 2:
                    confiteria.pedirComida(numero);
                    confiteria.comer(numero);
                    break;
                case 3:
                    confiteria.pedirBebida(numero);
                    confiteria.tomar(numero);
                    confiteria.pedirComida(numero);
                    confiteria.comer(numero);
                    break;
            }
            confiteria.desocuparEspacio(numero);
        } catch (Exception ex) {
        }
    }

}
