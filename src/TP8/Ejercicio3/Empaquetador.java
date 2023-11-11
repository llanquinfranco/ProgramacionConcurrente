package TP8.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Empaquetador extends Thread {

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
                Thread.sleep(150);
                caja.soltarPastel(peso);
            } catch (Exception ex) {

            }
        }

    }

}
