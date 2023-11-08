package TP8.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {

        Comedor comedor = new Comedor();

        for (int i = 1; i <= 80; i++) {
            Soldado soldado = new Soldado("Soldado " + i, i % 4, comedor);
            soldado.start();
        }

    }

}
