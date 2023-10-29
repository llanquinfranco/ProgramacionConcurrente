package TPO.TrenTuristico.Ejercicio2;

/**
 *
 * @author Fran
 */
public class ControlTren extends Thread {

    private Tren tren;

    public ControlTren(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        while (true) {
            try {
                tren.empezarRecorrido();
                System.out.println("El Tren Turistico inicio el recorrido");
                Thread.sleep(1000);
                System.out.println("El Tren Turistico finalizo el recorrido");
                tren.finalizarRecorrido();
            } catch (Exception ex) {
            }
        }
    }
}
