package Recuperatorio.PlantaSemaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Planta {

    private int cajaAgua;
    private int cajaVino;
    private int almacen;
    private Semaphore semAgua;
    private Semaphore semVino;
    private Semaphore semEmpaquetador;
    private Semaphore semTransportador;
    private Semaphore mutex;

    public Planta() {
        this.cajaAgua = 0;
        this.cajaVino = 0;
        this.almacen = 0;
        this.semAgua = new Semaphore(1);
        this.semVino = new Semaphore(1);
        this.semEmpaquetador = new Semaphore(0);
        this.semTransportador = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public void prepararBotellaAgua() throws InterruptedException {
        semAgua.acquire();
        cajaAgua++;
        System.out.println("El " + Thread.currentThread().getName() + " ubico"
                + " una botella de agua saborizada en la caja");
        System.out.println("Caja de agua saborizada: " + cajaAgua + "/10");
        if (cajaAgua == 10) {
            semEmpaquetador.release();
        } else {
            semAgua.release();
        }
    }

    public void prepararBotellaVino() throws InterruptedException {
        semVino.acquire();
        cajaVino++;
        System.out.println("El " + Thread.currentThread().getName() + " ubico"
                + " una botella de vino en la caja");
        System.out.println("Caja de vino: " + cajaVino + "/10");
        if (cajaVino == 10) {
            semEmpaquetador.release();
        } else {
            semVino.release();
        }
    }

    public void retirarCaja() throws InterruptedException {
        semEmpaquetador.acquire();
        if (cajaAgua == 10) {
            System.out.println("Se lleno la caja de agua saborizada y el empaquetador la retiro");
            mutex.acquire();
            almacen++;
            mutex.release();
            System.out.println("La caja de agua se guardo en el deposito");
            System.out.println("Almacen: " + almacen + "/10");
            if (almacen == 10) {
                semTransportador.release();
            }
        } else if (cajaVino == 10) {
            System.out.println("Se lleno la caja de vino y el empaquetador la retiro");
            mutex.acquire();
            almacen++;
            mutex.release();
            System.out.println("La caja de vino se guardo en el deposito");
            System.out.println("Almacen: " + almacen + "/10");
            if (almacen == 10) {
                semTransportador.release();
            }
        }
    }

    public void reponerCaja() {
        if (cajaAgua == 10) {
            cajaAgua = 0;
            System.out.println("Se repuso la caja de agua");
            semAgua.release();
        } else if (cajaVino == 10) {
            cajaVino = 0;
            System.out.println("Se repuso la caja de vino");
            semVino.release();
        }
    }

    public void transportar() throws InterruptedException {
        semTransportador.acquire();
        mutex.acquire();
        System.out.println("El almacen se lleno, un camion salio a repatir"
                + " todo el contenido del almacen");
        almacen = 0;
        mutex.release();
    }

}
