package TP7.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {

        Cocina cocina = new Cocina();

        for (int i = 1; i <= 20; i++) {
            Cocinero cocinero;
            switch (i % 3) {
                case 0:
                    cocinero = new Cocinero("Cocinero " + i + "(Carne)", 'C', cocina);
                    cocinero.start();
                    break;
                case 1:
                    cocinero = new Cocinero("Cocinero " + i + "(Vegetales)", 'V', cocina);
                    cocinero.start();
                    break;
                case 2:
                    cocinero = new Cocinero("Cocinero " + i + "(Pasta)", 'P', cocina);
                    cocinero.start();
                    break;
            }

        }

    }

}
