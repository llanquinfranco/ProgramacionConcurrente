package TP6.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {

        Sala sala = new Sala(5);
        
        Estudiante[] estudiantes = new Estudiante[17];
        for(int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = new Estudiante("Estudiante " + (i + 1), sala);
            estudiantes[i].start();
        }
        
    }

}
