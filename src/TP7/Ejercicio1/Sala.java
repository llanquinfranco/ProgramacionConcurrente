package TP7.Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Sala {

    private int jubiladosEsperando;
    private int capacidadMaxima;
    private int cantidadOcupada;
    private int tUmbral;
    private int tempActual;
    private Lock accesoSala;
    private Condition hayLugar;

    public Sala() {
        this.jubiladosEsperando = 0;
        this.capacidadMaxima = 50;
        this.cantidadOcupada = 0;
        this.tUmbral = 30;
        this.tempActual = 0;
        this.accesoSala = new ReentrantLock();
        this.hayLugar = accesoSala.newCondition();
    }

    public void entrarSala() {
        // Se invoca cuando una persona quiere entrar en la Sala
        try {
            accesoSala.lock();
            while (cantidadOcupada >= capacidadMaxima || jubiladosEsperando > 0) {
                hayLugar.await();
            }
            System.out.println(Thread.currentThread().getName() + " entro a la Sala");
            cantidadOcupada++;
        } catch (Exception ex) {

        } finally {
            accesoSala.unlock();
        }
    }

    public void entrarSalaJubilado() {
        // Se invoca cuando una persona jubilada quiere entrar en la Sala
        try {
            jubiladosEsperando++;
            accesoSala.lock();
            while (cantidadOcupada >= capacidadMaxima) {
                hayLugar.await();
            }
            System.out.println(Thread.currentThread().getName() + " entro a la Sala");
            cantidadOcupada++;
            jubiladosEsperando--;
        } catch (Exception ex) {

        } finally {
            accesoSala.unlock();
        }

    }

    public void salirSala() {
        // Se invoca cuando una persona, jubilada o no, quiere salir de la sala
        try {
            accesoSala.lock();
            System.out.println(Thread.currentThread().getName() + " salio de la Sala");
            cantidadOcupada--;
            hayLugar.signalAll();
        } catch (Exception ex) {

        } finally {
            accesoSala.unlock();
        }
    }

    public void notificarTemperatura(int temperatura) {
        // Lo invoca el hilo que mide la temperatura de la sala para indicar el ultimo valor medido
        try {
            accesoSala.lock();
            tempActual = temperatura;
            if (tempActual > tUmbral) {
                capacidadMaxima = 35;
            } else {
                capacidadMaxima = 50;
            }
            System.out.println("La Temperatura Actual es de " + tempActual + "°C");
            System.out.println("La Sala tiene una Capacidad Maxima de " + capacidadMaxima + " personas");
        } catch (Exception ex) {

        } finally {
            accesoSala.unlock();
        }
    }

}
