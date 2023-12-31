package TP6.Ejercicio4;

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

    public synchronized void producir() throws InterruptedException {
        // Mientras este lleno, el productor espera
        while (cantUsados == capacidad) {
            this.wait();
        }
        cantUsados++;
        System.out.println("El productor coloco un producto en el almacen, ahora hay " + cantUsados);
        this.notifyAll();
    }

    public synchronized void consumir() throws InterruptedException {
        // Mientras este vacio, el consumidor espera
        while (cantUsados == 0) {
            this.wait();
        }
        cantUsados--;
        System.out.println("El consumidor retiro un producto del almacen, ahora hay " + cantUsados);
        this.notifyAll();
    }

}
