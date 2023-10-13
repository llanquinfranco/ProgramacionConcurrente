package TPO.Ejercicio1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Tren {

    private int espacio;
    private int ocupacion;
    private Semaphore semDisponible;
    private Semaphore semLleno;
    private Semaphore semSalida;

    public Tren(int espacio) {
        this.espacio = espacio;
        this.ocupacion = 0;
        semDisponible = new Semaphore(1);
        semLleno = new Semaphore(0);
        semSalida = new Semaphore(0);
    }

    public void recorrer() throws InterruptedException {
        semLleno.acquire();
        System.out.println("El Tren Turistico inicio el recorrido");
        Thread.sleep(1000);
        System.out.println("El Tren Turistico finalizo el recorrido");
        semSalida.release();
    }

    public void subirAlTren(int numero) throws InterruptedException {
        semDisponible.acquire();
        this.ocupacion++;
        System.out.println("El Pasajero " + numero + " se subio al tren");
        if (ocupacion == espacio) {
            System.out.println("El tren se lleno");
            semLleno.release();
        } else {
            semDisponible.release();
        }
    }

    public void bajarseDelTren(int numero) throws InterruptedException {
        semSalida.acquire();
        this.ocupacion--;
        System.out.println("El Pasajero " + numero + " se bajo al tren");
        if (ocupacion == 0) {
            System.out.println("El tren se vacio");
            System.out.println("Esperando a que se llene para arrancar otro recorrido");
            System.out.println("-----------------------------------------------------");
            semDisponible.release();
        } else {
            semSalida.release();
        }
    }

}
