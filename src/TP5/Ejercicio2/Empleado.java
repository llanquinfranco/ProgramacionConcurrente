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
            confiteria.ocuparEspacio();
            switch (tipo) {
                case 1:
                    confiteria.tomar(tipo);
                    break;
                case 2:
                    confiteria.comer();
                    break;
                case 3:
                    confiteria.tomarYComer();
                    break;
            }
            confiteria.desocuparEspacio();
        } catch (Exception ex) {
        }
    }

}
