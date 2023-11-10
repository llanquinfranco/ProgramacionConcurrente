package TP8.Ejercicio4;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        SalaDeEspera sala = new SalaDeEspera();
        Donante[] donantes = new Donante[15];

        for (int i = 0; i < donantes.length; i++) {
            donantes[i] = new Donante("Donante " + i, sala);
            donantes[i].start();
        }
        
    }

}
