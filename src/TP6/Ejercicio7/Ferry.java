package TP6.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Ferry {

    private int espacio;
    private int ocupados;
    private boolean viajando;
    private boolean puedenBajar;

    public Ferry(int espacio) {
        this.espacio = espacio;
        this.ocupados = 0;
        this.viajando = false;
        this.puedenBajar = false;
    }

    public synchronized void subirPasajero() throws InterruptedException {
        while((ocupados == espacio) || viajando || puedenBajar) {
            this.wait();
        }
        ocupados++;
        System.out.println( "El " + Thread.currentThread().getName() + " se subio al ferry");
        System.out.println("Quedan " + (espacio - ocupados) + " espacios disponibles");
        this.notifyAll();
    }
    
    public synchronized void subirAutomovil(int lugares) throws InterruptedException {
        while((ocupados == espacio) || viajando || (lugares > (espacio - ocupados)) || puedenBajar) {
            this.wait();
        }
        ocupados = ocupados + lugares;
        System.out.println( "El " + Thread.currentThread().getName() + " se subio al ferry");
        System.out.println("Quedan " + (espacio - ocupados) + " espacios disponibles");
        this.notifyAll();
    }
    
    public synchronized void iniciarRecorrido() throws InterruptedException {
        while(ocupados < espacio) {
            this.wait();
        }
        viajando = true;
        System.out.println("--------------------------------------------------");
        System.out.println("El ferry zarpo del puerto");
    }
    
    public synchronized void finalizarRecorrido() throws InterruptedException {
        // no va wait creo xq no espera ninguna condicion
        viajando = false;
        System.out.println("El ferry llego a destino, empiezan a desembarcar");
        System.out.println("--------------------------------------------------");
        puedenBajar = true;
        this.notifyAll();
    }
    
    public synchronized void bajarPasajero() throws InterruptedException {
        while(!puedenBajar) {
            this.wait();
        }
        ocupados--;
        System.out.println( "El " + Thread.currentThread().getName() + " se bajo del ferry");
        System.out.println("Quedan " + ocupados + " lugares a desocupar");
        if(ocupados == 0) {
            puedenBajar = false;
            this.notifyAll();
        }
    }
    
    public synchronized void bajarAutomovil(int lugares) throws InterruptedException {
        while(!puedenBajar) {
            this.wait();
        }
        ocupados = ocupados - lugares;
        System.out.println( "El " + Thread.currentThread().getName() + " se bajo del ferry");
        System.out.println("Quedan " + ocupados + " lugares a desocupar");
        if(ocupados == 0) {
            puedenBajar = false;
            this.notifyAll();
        }
    }
    
}
