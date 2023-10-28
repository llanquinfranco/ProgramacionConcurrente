package TP6.Ejercicio5;

/**
 *
 * @author Fran
 */
public class Buffer {

    private int capacidad;
    private int cantUsados;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        this.cantUsados = 0;
    }

    public synchronized void producir(int numero) throws InterruptedException {
        // Mientras este lleno, el productor espera
        while (cantUsados == capacidad) {
            this.wait();
        }
        cantUsados++;
        Thread.sleep(500);
        System.out.println("El productor " + numero + " coloco un producto en el almacen, ahora hay " + cantUsados);
        this.notifyAll();
    }

    public synchronized void consumir(int numero) throws InterruptedException {
        // Mientras este vacio, el consumidor espera
        while (cantUsados == 0) {
            this.wait();
        }
        cantUsados--;
        Thread.sleep(500);
        System.out.println("El consumidor " + numero + " retiro un producto del almacen, ahora hay " + cantUsados);
        this.notifyAll();
    }

}
