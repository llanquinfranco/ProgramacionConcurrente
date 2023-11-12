package Parciales.BufferOscilante;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Buffer {
    // Ilimitado
    private int colaExtraer;
    private Queue<Object> cola1;
    private Queue<Object> cola2;
    private Semaphore semExtraer;
    private Semaphore semInsertar;
    private Semaphore semOscilacion;
    
    public Buffer() {
        this.colaExtraer = 2;
        this.cola1 = new LinkedList<>();
        this.cola2 = new LinkedList<>();
        this.semExtraer = new Semaphore(1);
        this.semInsertar = new Semaphore(1);
        this.semOscilacion = new Semaphore(1);
    }
    
    public void insertar(Object elem) throws InterruptedException {
        semInsertar.acquire();
        if(colaExtraer == 1) {
            System.out.println(Thread.currentThread().getName() + " inserto " + cola2.peek() + " en la cinta 2");
            cola2.add(elem);
        } else {
            System.out.println(Thread.currentThread().getName() + " inserto " + cola2.peek() + " en la cinta 1");
            cola1.add(elem);
        }
        semInsertar.release();
    }
    
    public void extraer() throws InterruptedException {
        semExtraer.acquire();
        if(colaExtraer == 1) {
            if(cola1.isEmpty()) {
                oscilar();
                cola2.poll();
                System.out.println(Thread.currentThread().getName() + " extrajo " + cola2.peek() + " de la cinta " + colaExtraer);
            } else {
                cola1.poll();
                System.out.println(Thread.currentThread().getName() + " extrajo " + cola1.peek() + " de la cinta " + colaExtraer);
            }
        } else {
            if(cola2.isEmpty()) {
                oscilar();
                cola1.poll();
                System.out.println(Thread.currentThread().getName() + " extrajo " + cola1.peek() + " de la cinta " + colaExtraer);
            } else {
                cola2.poll();
                System.out.println(Thread.currentThread().getName() + " extrajo " + cola2.peek() + " de la cinta " + colaExtraer);
            }
        }
        semExtraer.release();
    }
    
    private void oscilar() throws InterruptedException {
        semOscilacion.acquire();
        if(colaExtraer == 1) {
            colaExtraer = 2;
            System.out.println("La cola para extraer ahora es la 2");
        } else {
            colaExtraer = 1;
            System.out.println("La cola para extraer ahora es la 1");
        }
        semOscilacion.release();
    }
}
