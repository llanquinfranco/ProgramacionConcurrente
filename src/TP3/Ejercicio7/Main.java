package TP3.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Turnos turnos = new Turnos();
        Impresor impresorA = new Impresor('A', 3, turnos);
        Impresor impresorB = new Impresor('B', 4, turnos);
        Impresor impresorC = new Impresor('C', 3, turnos);
        Thread hiloA = new Thread(impresorA);
        Thread hiloB = new Thread(impresorB);
        Thread hiloC = new Thread(impresorC);
        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}