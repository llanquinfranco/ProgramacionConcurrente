package TP2.Ejercicio4;

/**
 *
 * @author Fran
 */
public class ThreadEjemplo implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadEjemplo hilo1 = new ThreadEjemplo();
        ThreadEjemplo hilo2 = new ThreadEjemplo();
        Thread thread1 = new Thread(hilo1, "Maria Jose");
        Thread thread2 = new Thread(hilo2, "Jose Maria");
        thread1.start();
        thread2.start();
        System.out.println("Termina thread main");
    }
    
}
