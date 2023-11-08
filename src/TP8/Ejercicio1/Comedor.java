package TP8.Ejercicio1;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Comedor {
    
    Random random = new Random();
    private Semaphore espacio;
    private Semaphore mostradorAlmuerzo;
    private Semaphore mostradorPostre;
    private Semaphore abridores;

    public Comedor() {
        this.espacio = new Semaphore(30);
        this.mostradorAlmuerzo = new Semaphore(4);
        this.mostradorPostre = new Semaphore(2);
        this.abridores = new Semaphore(3);
    }

    public void pedirBandeja() throws InterruptedException {
        espacio.acquire();
        System.out.println("El " + Thread.currentThread().getName() + " entro al cuartel");
        mostradorAlmuerzo.acquire();
        System.out.println("El " + Thread.currentThread().getName() + " esta usando un mostrador para el almuerzo");
        Thread.sleep(random.nextInt(1000, 2000));
        System.out.println("El " + Thread.currentThread().getName() + " dejo de usar un mostrador para el almuerzo");
        mostradorAlmuerzo.release();
    }

    public void pedirGaseosa() throws InterruptedException {
        abridores.acquire();
        System.out.println("El " + Thread.currentThread().getName() + " esta usando un abridor para abrir la gaseosa");
        Thread.sleep(random.nextInt(100, 200));
        System.out.println("El " + Thread.currentThread().getName() + " dejo de usar un abridor");
        abridores.release();
    }

    public void pedirPostre() throws InterruptedException {
        mostradorPostre.acquire();
        System.out.println("El " + Thread.currentThread().getName() + " esta usando un mostrador para el postre");
        Thread.sleep(random.nextInt(500, 1500));
        System.out.println("El " + Thread.currentThread().getName() + " dejo de usar un mostrador para el postre");
        mostradorPostre.release();
    }

    public void devolverBandeja() {
        System.out.println("El " + Thread.currentThread().getName() + " termino de comer y devolvio la bandeja");
        espacio.release();
    }

}
