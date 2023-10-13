package TP4.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        int i;
        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo(confiteria);
        mozo.start();

        Empleado[] empleados = new Empleado[10];
        for(i = 0 ; i < empleados.length; i++) {
            empleados[i] = new Empleado(i + 1, confiteria);
        }
        for(i = 0; i < empleados.length; i++) {
            empleados[i].start();
        }
    }

}
