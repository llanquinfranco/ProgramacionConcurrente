package TP4.Ejercicio4;

/**
 *
 * @author Fran
 */
public class GestorImpresoras {

    private Impresora[] colImpresoras = new Impresora[cantImpresoras];
    private static final int cantImpresoras = 4;

    public GestorImpresoras() {
        for (int j = 0; j < cantImpresoras; j++) {
            colImpresoras[j] = new Impresora(j + 1);
        }
    }

    public void buscar(int numero) throws InterruptedException {
        boolean encontro;
        int i = 0;
        do {
            Impresora impAux = colImpresoras[i];
            encontro = impAux.usar(numero);
            if (encontro) {
                //System.out.println(Thread.currentThread().getName() + " encontró impresora "+impAux.getId());
                Thread.sleep(1000);
                impAux.liberar(numero);
                //System.out.println(Thread.currentThread().getName() + " liberó impresora "+impAux.getId());
            } else {
                i = (i + 1) % cantImpresoras;
            }
        } while (!encontro);
    }
}
