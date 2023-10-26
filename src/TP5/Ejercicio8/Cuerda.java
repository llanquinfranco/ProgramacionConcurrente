package TP5.Ejercicio8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Cuerda {

    private int cantIzquierda;  // Cuantos se encuentran a la izquierda (cruzan hacia la derecha)
    private int cantDerecha;    // Cuantos se encuentran a la derecha (cruzan hacia la izquierda)
    private int subidos;        // Cuantos se encuentran subidos en la cuerda
    private Semaphore semEsperandoIzquierda;    // Para controlar los que deben cruzar hacia la derecha
    private Semaphore semEsperandoDerecha;      // Para controlar los que deben cruzar hacia la izquierda
    private Semaphore salida;   // Para indicar que se baje de la cuerda
    private Semaphore mutex;    // Para la exclusion mutua
    private Semaphore comprobar;    // Para que no se bugee al comprobar el cambio
    
    public Cuerda(int cantIzquierda, int cantDerecha) {
        this.cantIzquierda = cantIzquierda;
        this.cantDerecha = cantDerecha;
        this.subidos = 0;
        this.semEsperandoIzquierda = new Semaphore(5);
        this.semEsperandoDerecha = new Semaphore(0);
        this.salida = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.comprobar = new Semaphore(1);
    }

    public void cruzarHaciaLaDerecha(int numero) throws InterruptedException {
        // Se suben a la cuerda, de a uno
        semEsperandoIzquierda.acquire();
        System.out.println("El Babuino " + numero + " se subio a la cuerda para cruzar hacia el lado derecho");
        mutex.acquire();
        cantIzquierda--;
        subidos++;
        mutex.release();
        // Cuando se suben 5, o no quedan mas que quieran cruzar hacia la derecha, cruzan
        if (subidos == 5 || cantIzquierda == 0) {
            System.out.println(subidos + " babuinos estan cruzando hacia el lado derecho");
            //Thread.sleep(2000);
            salida.release(subidos);
        }
        // Se bajan de a uno
        salida.acquire();
        mutex.acquire();
        subidos--;
        System.out.println("El Babuino " + numero + " ya se encuentra en el lado derecho");
        mutex.release();
        // Cuando se bajan todos
        comprobar.acquire();
        if (subidos == 0) {
            if (cantDerecha > 0) {
                // Si quedan babuinos que quieran cruzan hacia la izquierda, cambiamos
                semEsperandoDerecha.release(5);
            } else if (cantIzquierda > 0) {
                // Sino, siguen cruzando hacia la derecha los que quedan
                semEsperandoIzquierda.release(5);
            }
        }
        comprobar.release();
    }

    public void cruzarHaciaLaIzquierda(int numero) throws InterruptedException {
        // Se suben a la cuerda, de a uno
        semEsperandoDerecha.acquire();
        System.out.println("El Babuino " + numero + " se subio a la cuerda para cruzar hacia el lado izquierdo");
        mutex.acquire();
        cantDerecha--;
        subidos++;
        mutex.release();
        // Cuando se suben 5, o no quedan mas que quieran cruzar hacia la derecha, cruzan
        if (subidos == 5 || cantDerecha == 0) {
            System.out.println(subidos + " babuinos estan cruzando hacia el lado izquierdo");
            //Thread.sleep(1000);
            salida.release(subidos);
        }
        // Se bajan de a uno
        salida.acquire();
        mutex.acquire();
        subidos--;
        System.out.println("El Babuino " + numero + " ya se encuentra en el lado izquierdo");
        mutex.release();
        // Cuando se bajan todos
        comprobar.acquire();
        if (subidos == 0) {
            if (cantIzquierda > 0) {
                // Si quedan babuinos que quieran cruzan hacia la derecha, cambiamos
                semEsperandoIzquierda.release(5);
            } else if (cantDerecha > 0) {
                // Sino, siguen cruzando hacia la izquierda los que quedan
                semEsperandoDerecha.release(5);
            }
        }
        comprobar.release();
    }

}