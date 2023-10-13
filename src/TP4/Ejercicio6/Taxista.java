package TP4.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Taxista extends Thread {

    private Taxi taxi;

    public Taxista(Taxi taxi) {
        this.taxi = taxi;
    }

    public void run() {
        while(true) {
            try {
                taxi.iniciarRecorrido();
                System.out.println("El Taxista arranco el recorrido");
                Thread.sleep(1000);
                System.out.println("El Taxista termino el recorrido");
                taxi.finalizarRecorrido();
            } catch (Exception ex) {
            }
        }
    }
}
