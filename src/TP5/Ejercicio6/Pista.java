package TP5.Ejercicio6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Pista {

    private int cantDespegues;  // Para saber cuantos despegues va a haber en total
    private int cantAterrizajes;    // Para saber cuantos aterrizajes va a haber en total
    private int aterrizados;    // Para controlar que ya hayan aterrizado todos
    private boolean despego;    // Para controlar que ya haya despegado
    private char turno;     // Para elegir con que empezar y controlar quien tiene el turno
    private Semaphore semDespegue;
    private Semaphore semAterrizaje;
    private Semaphore mutex;    // Para la exclusion mutua
    private Semaphore mutexTorre;   // Para avisarle a la torre cuando debe controlar

    public Pista(int cantDespegues, int cantAterrizajes, char turno) {
        this.cantDespegues = cantDespegues;
        this.cantAterrizajes = cantAterrizajes;
        this.aterrizados = 0;
        this.despego = false;
        if (turno == 'A') {
            this.semAterrizaje = new Semaphore(10);
            this.semDespegue = new Semaphore(0);
        } else if (turno == 'D') {
            this.semAterrizaje = new Semaphore(0);
            this.semDespegue = new Semaphore(1);
        }
        this.turno = turno;
        this.mutex = new Semaphore(1);
        this.mutexTorre = new Semaphore(0);
    }

    public void controlar() throws InterruptedException {
        mutexTorre.acquire();
        // Modulo para que la torre controle si deben despegar o aterrizar
        if (turno == 'A') {
            // Si es el turno que aterricen
            if (aterrizados == 10) {
                // Si ya aterrizaron 10 entonces
                if (cantAterrizajes > 0 && cantDespegues == 0) {
                    // Si no quedan despegues, siguen aterrizando los demas (bucle)
                    aterrizados = 0;
                    semAterrizaje.release(10);
                } else {
                    // Sino, hago el cambio para que despegue uno
                    despego = false;
                    turno = 'D';
                    semDespegue.release();
                }
            } else if (cantAterrizajes == 0 && cantDespegues > 0) {
                // Si no quedan mas aterrizajes, ahora despegan los que quedan
                despego = false;
                turno = 'D';
                semDespegue.release();
            }
        } else if (turno == 'D') {
            // Si es el turno que aterricen
            if (despego) {
                // Si ya despego uno
                if (cantDespegues > 0 && cantAterrizajes == 0) {
                    // Si no quedan aterrizajes, siguen despegando los demas (bucle)
                    despego = false;
                    semDespegue.release();
                } else {
                    // Sino, hago el cambio para que aterricen 10
                    aterrizados = 0;
                    turno = 'A';
                    semAterrizaje.release(10);
                }
            } else if (cantDespegues == 0 && cantAterrizajes > 0) {
                // Si no quedan mas despegues, ahora aterrizan los que quedan
                aterrizados = 0;
                turno = 'A';
                semAterrizaje.release(10);
            }
        }
    }

    public void aterrizar(int id) throws InterruptedException {
        semAterrizaje.acquire();
        mutex.acquire();
        System.out.println("--------------------------------------------------------------");
        System.out.println("El Avion con ID: " + id + " va a aterrizar");
        Thread.sleep(500);
        System.out.println("El Avion con ID: " + id + " ya esta en tierra, fuera de la pista");
        aterrizados++;
        cantAterrizajes--;
        mutex.release();
        mutexTorre.release();
    }

    public void despegar(int id) throws InterruptedException {
        semDespegue.acquire();
        mutex.acquire();
        System.out.println("--------------------------------------------------------------");
        System.out.println("El Avion con ID: " + id + " va a despegar");
        Thread.sleep(700);
        System.out.println("El Avion con ID: " + id + " ya esta volando");
        despego = true;
        cantDespegues--;
        mutex.release();
        mutexTorre.release();
    }

}
