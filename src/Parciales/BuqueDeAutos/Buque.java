package Parciales.BuqueDeAutos;

import java.util.Random;
import java.util.concurrent.Semaphore;


/**
 *
 * @author Fran
 */
public class Buque {
    
    Random random = new Random();
    private int capacidad;
    private int ocupacion;
    private Semaphore semEspacios;
    private Semaphore semViaje;
    private Semaphore semSalida;
    private Semaphore semVuelta;
    private Semaphore mutex;
    

    public Buque() {
        this.capacidad = 10;
        this.ocupacion = 0;
        this.semEspacios = new Semaphore(10);
        this.semViaje = new Semaphore(0);
        this.semSalida = new Semaphore(0);
        this.semVuelta = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public void entrar() throws InterruptedException {
        semEspacios.acquire();
        mutex.acquire();
        ocupacion++;
        Thread.sleep(random.nextInt(500,1500));
        System.out.println("El " + Thread.currentThread().getName() + " se subio al Buque");
        System.out.println("Buque: " + ocupacion + " / " + capacidad);
        mutex.release();
        semViaje.release();
    }
    
    public void ir() throws InterruptedException {
        semViaje.acquire(10);
        System.out.println("------------------------------------------------------------");
        System.out.println("El Buque se lleno y esta cruzando el rio");
        Thread.sleep(2000);
        System.out.println("El Buque llego al lado Oeste");
        System.out.println("Empiezan a bajar");
        System.out.println("------------------------------------------------------------");
        semSalida.release(10);
    }
    
    public void salir() throws InterruptedException {
        semSalida.acquire();
        mutex.acquire();
        ocupacion--;
        Thread.sleep(random.nextInt(500,1500));
        System.out.println("El " + Thread.currentThread().getName() + " se bajo del buque");
        System.out.println("Buque: " + ocupacion + " / " + capacidad);
        mutex.release();
        if(ocupacion == 0) {
            semVuelta.release();
        }
    }
    
    public void volver() throws InterruptedException {
        semVuelta.acquire();
        System.out.println("------------------------------------------------------------");
        System.out.println("Ya se vacio el Buque");
        System.out.println("El Buque esta volviendo");
        Thread.sleep(2000);
        System.out.println("El Buque volvio al lado Este");
        System.out.println("------------------------------------------------------------");
        semEspacios.release(10);
    }
}



/*
public class Buque {

    private int capacidad;
    private int ocupacion;
    private boolean estaEnTierra;
    private boolean estaVolviendo;
    private boolean estaViajando;
    private Lock accesoBuque;
    private Condition autos;
    private Condition control;

    public Buque() {
        this.capacidad = 10;
        this.ocupacion = 0;
        this.estaEnTierra = true;
        this.estaVolviendo = false;
        this.estaViajando = false;
        this.accesoBuque = new ReentrantLock();
        this.autos = accesoBuque.newCondition();
        this.control = accesoBuque.newCondition();
    }

    public void entrar() throws InterruptedException {
        try {
            accesoBuque.lock();
            while((ocupacion == capacidad) || estaViajando || estaVolviendo || !estaEnTierra) {
                autos.await();
            }
            ocupacion++;
            System.out.println("El " + Thread.currentThread().getName() + " se subio al ferry");
            System.out.println("Buque: " + ocupacion + " / " + capacidad);
            if(ocupacion == capacidad) {
                control.signal();
            }
        } finally {
            accesoBuque.unlock();
        }
    }
    
    public void ir() throws InterruptedException {
        try {
            accesoBuque.lock();
            while((ocupacion < capacidad)) {
                control.await();
            }
            estaViajando = true;
            System.out.println("El buque arranco el recorrido");
            Thread.sleep(2000);
            autos.signal();
        } finally {
            accesoBuque.unlock();
        }
    }
    
    public void salir() {
        try {
            accesoBuque.lock();
            
            
            
            
        } finally {
            accesoBuque.unlock();
        }
    }
    
    public void volver() {
        try {
            accesoBuque.lock();
            
            
            
            
        } finally {
            accesoBuque.unlock();
        }
    }
}
*/