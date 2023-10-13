package TP4.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Mozo extends Thread {

    private Confiteria confiteria;

    public Mozo(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        while (true) {
            try {
                confiteria.prepararComida();
                System.out.println("El Mozo esta preparando la comida");
                Thread.sleep(500);
                System.out.println("El Mozo le sirvio la comida y le indico que puede empezar a comer");
                confiteria.servirComida();
            } catch (Exception ex) {
            }
        }

    }

}
