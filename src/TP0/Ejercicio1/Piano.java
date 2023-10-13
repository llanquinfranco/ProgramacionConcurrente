package TP0.Ejercicio1;

/**
 *
 * @author Fran
 */
class Piano extends Instrumento {

    public void tocar() {
        System.out.println("Piano.tocar()");
    }

    public String tipo() {
        return "Piano";
    }

    public void afinar() {
    }
}
