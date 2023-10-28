package TP6.Ejercicio6;

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
        // Nunca se llena ya que es ilimitado, entonces no va wait ¿?
        cantUsados++;
        //Thread.sleep(500);
        System.out.println("El productor " + numero + " coloco un producto en el almacen, ahora hay " + cantUsados);
        // Es necesario xq sino solo se produce y nunca se consume ¿?
        this.notifyAll();
    }

    public synchronized void consumir(int numero) throws InterruptedException {
        // Mientras este vacio, el consumidor espera
        while (cantUsados == 0) {
            this.wait();
        }
        cantUsados--;
        //Thread.sleep(500);
        System.out.println("El consumidor " + numero + " retiro un producto del almacen, ahora hay " + cantUsados);
        this.notifyAll();
    }

}
