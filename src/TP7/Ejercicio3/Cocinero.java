package TP7.Ejercicio3;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Cocinero extends Thread {

    private char tipo;
    private Cocina cocina;
    Random r = new Random();

    public Cocinero(String nombre, char tipo, Cocina cocina) {
        super(nombre);
        this.tipo = tipo;
        this.cocina = cocina;
    }

    public void run() {
        while (true) {
            try {
                switch (tipo) {
                    case 'C':
                        cocina.cocinarCarne();
                        Thread.sleep(r.nextInt(1000, 2000)); // Cocina
                        cocina.reponerCarne();
                        Thread.sleep(500);  // Descansa un toque asi no vuelve a agarrar el mismo cocinero q repuso
                        break;
                    case 'V':
                        cocina.cocinarEnsalada();
                        Thread.sleep(r.nextInt(1000, 2000)); // Cocina
                        cocina.reponerVegetales();
                        Thread.sleep(500);  // Descansa un toque asi no vuelve a agarrar el mismo cocinero q repuso
                        break;
                    case 'P':
                        cocina.cocinarPasta();
                        Thread.sleep(r.nextInt(1000, 2000)); // Cocina
                        cocina.reponerPasta();
                        Thread.sleep(500);  // Descansa un toque asi no vuelve a agarrar el mismo cocinero q repuso
                }
            } catch (Exception ex) {

            }
        }

    }

}
