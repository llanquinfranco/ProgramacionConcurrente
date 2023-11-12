package Parciales.ParqueConcurrido;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Parque parque = new Parque(10);

        for (int i = 1; i < 48; i++) {
            if (i % 4 == 0) {
                Persona persona = new Persona("Visitante " + i + " (Residente)", true, parque);
                persona.start();
            } else {
                Persona persona = new Persona("Visitante " + i + " (Comun)", false, parque);
                persona.start();
            }
        }
    }

}
