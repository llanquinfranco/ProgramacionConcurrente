package Recuperatorio.AtomosLocksMonitores;

/**
 *
 * @author Fran
 */
public class Recipiente {
    
    private int capacidad;
    private int ocupacion;
    private int oxigenos;
    private int hidrogenos;
    
    public Recipiente(int capacidad) {
        this.capacidad = capacidad;
        this.ocupacion = 0;
        this.oxigenos = 0;
        this.hidrogenos = 0;
    }
    
    public synchronized void Olisto() throws InterruptedException {
        oxigenos++;
        System.out.println("El " + Thread.currentThread().getName() + " esta listo");
        if(hidrogenos >= 2 && oxigenos >= 1) {
            this.notifyAll();
        }
    }
    
    
    public synchronized void Hlisto() throws InterruptedException {
        hidrogenos++;
        System.out.println("El " + Thread.currentThread().getName() + " esta listo");
        if(hidrogenos >= 2 && oxigenos >= 1) {
            this.notifyAll();
        }
    }
    
    public synchronized void hacerAgua() throws InterruptedException {
        while(hidrogenos < 2 && oxigenos < 1) {
            this.wait();
        }
        System.out.println("Se encontraron 2 Hidrogenos y 1 Oxigeno");
        System.out.println("Formando molecula de Agua...");
        Thread.sleep(1000);
        hidrogenos = hidrogenos - 2;
        oxigenos--;
        ocupacion++;
        System.out.println("Se deposito 1 molecula de Agua en el recipiente");
        System.out.println("Recipiente: " + ocupacion + "/" + capacidad);
        if(ocupacion == capacidad) {
            ocupacion = 0;
            System.out.println("El contenido del recipiente fue envasado para su produccion");
            System.out.println("Ahora esta vacio");
        }
    }
}
