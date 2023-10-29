package TPO.TrenTuristico.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Tren tren = new Tren(5);
        int cantidad = 20, i;
        MaquinaTickets maquina = new MaquinaTickets(15);

        Pasajero[] pasajeros = new Pasajero[cantidad];
        for (i = 0; i < cantidad; i++) {
            pasajeros[i] = new Pasajero(i + 1, tren, maquina);
        }
        for (i = 0; i < cantidad; i++) {
            pasajeros[i].start();
        }

        ControlTren controlTren = new ControlTren(tren);
        controlTren.start();
    }

}
