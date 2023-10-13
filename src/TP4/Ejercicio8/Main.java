package TP4.Ejercicio8;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        int i;
        ControladorProduccion controlador = new ControladorProduccion('E');
        Control control = new Control(controlador);
        control.start();
        Producto[] electricos = new Producto[4];
        Producto[] mecanicos = new Producto[6];
        for (i = 0; i < mecanicos.length; i++) {
            mecanicos[i] = new Producto(i + 1, 'M', controlador);
        }
        for (i = 0; i < electricos.length; i++) {
            electricos[i] = new Producto(i + 1, 'E', controlador);
        }
        for(i = 0; i < mecanicos.length; i++) {
            mecanicos[i].start();
        }
        for(i = 0; i < electricos.length; i++) {
            electricos[i].start();
        }
    }
}
