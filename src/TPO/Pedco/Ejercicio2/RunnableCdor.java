package TPO.Pedco.Ejercicio2;

/**
 *
 * @author Fran
 */
class RunnableCdor implements Runnable {
    Dato unContador;

    public RunnableCdor(Dato elCdor) {
        unContador = elCdor;
    }

    public void run() {
        for (int x = 0; x < 10000; ++x) {
            unContador.contar();
        }
    }
}
