package TPO.Pedco.Ejercicio1;

/**
 *
 * @author Fran
 */
class Dato {
    private int valor;

    void contar() {
        valor = ++valor;
    }

    int obtenerValor() {
        return valor;
    }
}