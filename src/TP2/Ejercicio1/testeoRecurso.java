package TP2.Ejercicio1;

/**
 *
 * @author Fran
 */
public class testeoRecurso {

    public static void main(String[] args) {
        Cliente juan = new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines = new Cliente();
        ines.setName("Ines Garcia");
        ines.start();
        juan.start();
        Recurso.uso();
    }
}
