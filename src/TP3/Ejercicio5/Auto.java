package TP3.Ejercicio5;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Auto extends Thread {

    private final String nombre;
    private int tanque;

    public Auto(String nombre, int tanque) {
        this.nombre = nombre;
        this.tanque = tanque;
    }

    private Surtidor surtidor = new Surtidor();

    private synchronized void avanzar() throws InterruptedException {
        Random random = new Random();
        int consumo = random.nextInt(51);
        this.tanque = this.tanque - consumo;
        System.out.println("El " + this.nombre + " consumio " + consumo + " litros de combustible de su tanque");
        System.out.println("Ahora el " + this.nombre + " tiene " + this.tanque + " litros de combustible en su tanque");
    }

    private synchronized void cargar() throws InterruptedException {
        Random random = new Random();
        int carga = random.nextInt(51);
        if (surtidor.getCapacidadActual() > 0 && carga <= surtidor.getCapacidadActual()) {
            surtidor.surtir(carga);
            this.tanque = this.tanque + carga;
            System.out.println("El " + this.nombre + " cargo " + carga + " litros de combustible");
            System.out.println("Ahora el " + this.nombre + " tiene " + this.tanque + " litros de combustible");
            System.out.println("El surtidor cuenta todavia con " + surtidor.getCapacidadActual() + " litros de combustible");
        } else {
            System.out.println("El " + this.nombre + " no pudo cargar combustible porque"
                    + " el surtidor no posee suficiente combustible");
        }
    }

    public synchronized void run() {
        int i;
        for (i = 0; i <= 8; i++) {
            try {
                if (this.tanque > 0) {
                    this.avanzar();
                } else {
                    this.cargar();
                }
            } catch (Exception ex) {
            }
        }
    }

    /*
    public synchronized void run() {
        Random random = new Random();
        int i;
        for(i = 0; i <= 8; i++) {
            try {
                if(this.tanque > 0) {
                    int consumo = random.nextInt(51);
                    this.tanque = this.tanque - consumo;
                    System.out.println("El " + this.nombre + " tiene " + this.tanque + " litros de combustible en su tanque");
                    Thread.sleep(100);
                } else {
                    int carga = random.nextInt(51);
                    if(surtidor.getCapacidadActual() > 0 && carga <= surtidor.getCapacidadActual()) {
                        surtidor.surtir(carga);
                        this.tanque = this.tanque + carga;
                        System.out.println("El " + this.nombre + " ahora tiene " + this.tanque + " litros de combustible");
                        System.out.println("El surtidor cuenta con " + surtidor.getCapacidadActual() + " litros");
                    } else {
                        System.out.println("El " + this.nombre + " no pudo realizar una carga de combustible porque"
                                + " no le alcanza lo que tiene el sutidor");
                    }
                }
            } catch (InterruptedException exc) {
                System.out.println("Auto rompido¿?");
            }
        }
    }
     */
}
