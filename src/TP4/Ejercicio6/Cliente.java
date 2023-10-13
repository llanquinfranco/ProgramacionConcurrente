package TP4.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Cliente extends Thread {

    private int numero;
    private Taxi taxi;

    public Cliente(int numero, Taxi taxi) {
        this.numero = numero;
        this.taxi = taxi;
    }

    public void run() {
        try {
            taxi.subirseAlTaxi();
            System.out.println("-----------------------------------------------");
            System.out.println("El Cliente " + numero + " se subio al Taxi");
            System.out.println("El Cliente " + numero + " le indico el destino");
            taxi.despertarTaxista();
            taxi.bajarseDelTaxi();
            System.out.println("El Cliente " + numero + " se bajo del Taxi");
            System.out.println("El Taxista esta mimiendo esperando mas Clientes");
            taxi.dormirTaxista();
        } catch (Exception ex) {
        }
    }

}
