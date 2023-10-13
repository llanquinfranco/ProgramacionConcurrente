package TP3.Ejercicio2;

/**
 *
 * @author franco.llanquin
 */
public class Criatura implements Runnable {

    private final Energia personaje = new Energia();

    private synchronized void realizarAccion() throws InterruptedException {
        if (personaje.getEnergia() > 0) {
            if (Thread.currentThread().getName().equals("La Criatura Oscura")) {
                System.out.println("La Criatura Oscura dreno -3 puntos de energia");
                personaje.drenar();
                System.out.println("El personaje tiene ahora " + personaje.getEnergia() + " puntos de energia");
            } else if (Thread.currentThread().getName().equals("El Sanador")) {
                System.out.println("El Sanador revitalizo +3 puntos de energia");
                personaje.revitalizar();
                System.out.println("El personaje tiene ahora " + personaje.getEnergia() + " puntos de energia");
            }
        } else {
            System.out.println("El personaje se quedo sin energia");
            System.out.println("Su energia actual es de " + personaje.getEnergia());
        }

    }

    public void run() {
        while(personaje.getEnergia() > 0) {
            try {
                this.realizarAccion();
            } catch (Exception ex) {
            }
        }
    }
}
