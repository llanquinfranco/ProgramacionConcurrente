package TP4.Ejercicio8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class ControladorProduccion {

    private Semaphore semElectrico;
    private Semaphore semMecanico;
    private char entrando;

    public ControladorProduccion(char entrando) {
        // como hago para empezar con mecanico o electrico, mando parametro y hago if ¿?
        if (entrando == 'E') {
            this.semElectrico = new Semaphore(1);
            this.semMecanico = new Semaphore(0);
        } else if (entrando == 'M') {
            this.semElectrico = new Semaphore(0);
            this.semMecanico = new Semaphore(1);
        }
        this.entrando = entrando;
    }

    public void llegaElectrico(int numero) throws InterruptedException {

        semElectrico.acquire();
        System.out.println("El Producto Electrico ID:" + numero + ", esta pasando por la linea de ensamblaje");
        Thread.sleep(100);
        sale('E', numero);

    }

    public void llegaMecanico(int numero) throws InterruptedException {

        semMecanico.acquire();
        System.out.println("El Producto Mecanico ID:" + numero + ", esta pasando por la linea de ensamblaje");
        Thread.sleep(100);
        sale('M', numero);

    }

    public void sale(char tipo, int numero) {
        if (tipo == 'E') {
            System.out.println("El Producto Electrico ID:" + numero + ", salio de la linea de ensamblaje");
            semElectrico.release();
        } else if (tipo == 'M') {
            System.out.println("El Producto Mecanico ID:" + numero + ", salio de la linea de ensamblaje");
            semMecanico.release();
        }
    }

    public synchronized void cambiaLineas() throws InterruptedException {
        
        
        if (entrando == 'E') {
            
            semElectrico.acquire(semElectrico.availablePermits());
            semMecanico.release();
            entrando = 'M';

        } else if (entrando == 'M') {
            
            semMecanico.acquire(semElectrico.availablePermits());
            semElectrico.release();
            entrando = 'E';
            
        }

    }

}
