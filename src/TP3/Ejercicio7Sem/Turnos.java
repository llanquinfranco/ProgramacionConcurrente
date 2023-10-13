package TP3.Ejercicio7Sem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Fran
 */
public class Turnos {

    Semaphore semaforoA = new Semaphore(1);
    Semaphore semaforoB = new Semaphore(0);
    Semaphore semaforoC = new Semaphore(0);

    public void imprimir(char caracter, int cantidad) throws InterruptedException {
        switch (caracter) {
            case 'A':
                imprimirA(cantidad);
                break;
            case 'B':
                imprimirB(cantidad);
                break;
            case 'C':
                imprimirC(cantidad);
                break;
        }
    }

    private void imprimirA(int cantidad) throws InterruptedException {
        int i;
        semaforoA.acquire();
        for (i = 1; i <= cantidad; i++) {
            System.out.print("A");
            Thread.sleep(300);
        }
        semaforoB.release();
    }
    
    private void imprimirB(int cantidad) throws InterruptedException {
        int i;
        semaforoB.acquire();
        for (i = 1; i <= cantidad; i++) {
            System.out.print("B");
            Thread.sleep(300);
        }
        semaforoC.release();
    }
    
    private void imprimirC(int cantidad) throws InterruptedException {
        int i;
        semaforoC.acquire();
        for (i = 1; i <= cantidad; i++) {
            System.out.print("C");
            Thread.sleep(300);
        }
        semaforoA.release();
    }

}
