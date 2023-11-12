package Parciales.ParqueConcurrido;

/**
 *
 * @author Fran
 */
public class Parque {
    
    private int capacidad;
    private int ocupacion;
    private int residentesEsperando;
    
    public Parque(int capacidad) {
        this.capacidad = capacidad;
        this.ocupacion = 0;
        this.residentesEsperando = 0;
    }
    
    public synchronized void entrarResidente() throws InterruptedException{
        residentesEsperando++;
        while(ocupacion == capacidad) {
            this.wait();
        }
        ocupacion++;
        System.out.println("El " + Thread.currentThread().getName() + " entro al parque");
        System.out.println("Parque: " + ocupacion + " / " + capacidad);
    }
    
    public synchronized void entrarVisitante() throws InterruptedException {
        // Solo cuando esta lleno le damos prioridad a los residentes?  (residentesEsperando > 0 && ocupacion == capacidad)
        // O siempre le damos prioridad?    (residentesEsperando > 0)
        while(ocupacion == capacidad || (residentesEsperando > 0 && ocupacion == capacidad)) {
            this.wait();
        }
        ocupacion++;
        System.out.println("El " + Thread.currentThread().getName() + " entro al parque");
        System.out.println("Parque: " + ocupacion + " / " + capacidad);
    }
    
    public synchronized void salirResidente() {
        residentesEsperando--;
        ocupacion--;
        System.out.println("El " + Thread.currentThread().getName() + " salio del parque");
        System.out.println("Parque: " + ocupacion + " / " + capacidad);
        this.notifyAll();
    }
    
    public synchronized void salirVisitante() {
        ocupacion--;
        System.out.println("El " + Thread.currentThread().getName() + " salio del parque");
        System.out.println("Parque: " + ocupacion + " / " + capacidad);
        this.notifyAll();
    }
}
