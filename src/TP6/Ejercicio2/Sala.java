package TP6.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Sala {
    
    private int limiteMaximo;
    private int cantUsados;
    
    public Sala(int limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
        this.cantUsados = 0;
    }
    
    public synchronized void entrar() throws InterruptedException {
        // Si todas las mesas están ocupadas, debe esperar hasta que una se desocupe
        while(this.cantUsados == this.limiteMaximo) {
            System.out.println(Thread.currentThread().getName() + " debe esperar para entrar");
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " entro a la Sala y esta estudiando");
        cantUsados++;
    }
    
    public synchronized void salir() {
        System.out.println(Thread.currentThread().getName() + " termino de estudiar y sale");
        cantUsados--;
        this.notify();
    }
    
}
