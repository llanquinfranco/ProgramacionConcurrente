package TP8.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {

        Observatorio observatorio = new Observatorio();

        for (int i = 1; i < 100; i++) {
            if (i % 9 == 0) {
                Visitante visitante = new Visitante("Visitante " + i, true, observatorio);
                visitante.start();
            } else {
                Visitante visitante = new Visitante("Visitante " + i, false, observatorio);
                visitante.start();
            }
        }

        for (int j = 0; j < 20; j++) {
            Mantenimiento mantenimiento = new Mantenimiento("Persona de Mantenimiento " + j, observatorio);
            mantenimiento.start();
        }

        for (int k = 0; k < 10; k++) {
            Investigador investigador = new Investigador("Investigador " + k, observatorio);
            investigador.start();
        }

    }

}
