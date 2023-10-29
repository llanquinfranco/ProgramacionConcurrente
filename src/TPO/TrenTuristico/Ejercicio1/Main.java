package TPO.TrenTuristico.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Tren tren = new Tren(5);
        int cantidad = 20, i;
        ControlTren controlTren = new ControlTren(tren);
        
        Pasajero[] pasajeros = new Pasajero[cantidad];
        for(i = 0; i < cantidad; i++) {
            pasajeros[i] = new Pasajero(i + 1, tren);
        }
        for(i = 0; i < cantidad; i++) {
            pasajeros[i].start();
        }
        
        controlTren.start();
    }
    
}
