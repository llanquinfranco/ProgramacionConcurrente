package TP5.Ejercicio1;

/**
 *
 * @author Fran
 */
public class GestorPiscina {

    private Piscina piscina;


    public GestorPiscina(Piscina piscina) {
        this.piscina = piscina;
    }

    public void nadar(int numero) {
        try {
            piscina.dejarEntrar(numero);
        } catch (Exception ex) {

        }
    }

}
