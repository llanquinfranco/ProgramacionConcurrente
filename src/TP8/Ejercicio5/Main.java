package TP8.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Olla olla = new Olla(10);

        Cocinero cocinero = new Cocinero(olla);
        cocinero.start();

        for (int i = 1; i < 51; i++) {
            Canibal canibal = new Canibal("Canibal " + i, olla);
            canibal.start();
        }
    }

}
