package TP4.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Empleado extends Thread {

    private int numero;
    private Confiteria confiteria;

    public Empleado(int numero, Confiteria confiteria) {
        this.numero = numero;
        this.confiteria = confiteria;
    }

    public void run() {
        try {
            confiteria.ocuparEspacio();
            System.out.println("----------------------------------------------------------------");
            System.out.println("El Empleado " + numero + " se sento en la confiteria");
            System.out.println("El Empleado " + numero + " le pide la carta al mozo y elige el menu");
            confiteria.esperarComida();
            confiteria.empezarAComer();
            System.out.println("El Empleado " + numero + " esta comiendo");
            Thread.sleep(1000);
            System.out.println("El Empleado " + numero + " termino la comida, pago y se fue");
            confiteria.desocuparEspacio();
        } catch (Exception ex) {
        }
    }

}
