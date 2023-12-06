package Parciales.Compania;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Compania compania = new Compania();

        Filmador filmador = new Filmador(compania);
        filmador.start();

        Traductor traductor1 = new Traductor("Traductor 1", compania);
        traductor1.start();
        Traductor traductor2 = new Traductor("Traductor 2", compania);
        traductor2.start();

        for (int i = 1; i <= 5; i++) {
            Socio socioEspanol = new Socio("Socio " + i, 'E', compania);
            socioEspanol.start();
        }

        for (int j = 6; j <= 10; j++) {
            Socio socioIngles = new Socio("Socio " + j, 'I', compania);
            socioIngles.start();
        }
    }

}
