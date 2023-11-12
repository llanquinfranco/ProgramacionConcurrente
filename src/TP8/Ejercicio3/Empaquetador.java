package TP8.Ejercicio3;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Empaquetador extends Thread {
    
    Random random = new Random();
    private Mostrador mostrador;
    private Caja caja;

    public Empaquetador(String nombre, Mostrador mostrador, Caja caja) {
        super(nombre);
        this.mostrador = mostrador;
        this.caja = caja;
    }

    public void run() {
        while (true) {
            try {
                int peso = mostrador.tomarPastel();
                Thread.sleep(random.nextInt(400, 1000));
                caja.soltarPastel(peso);
            } catch (Exception ex) {

            }
        }

    }

}
