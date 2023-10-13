package TP4.Ejercicio5;

/**
 *
 * @author Fran
 */
public class GestorImpresoras {

    private Impresora[] colImpresorasA;
    private Impresora[] colImpresorasB;
    private static final int cantImpresoras = 4;

    public GestorImpresoras(int cantA, int cantB) {
        colImpresorasA = new Impresora[cantA];
        colImpresorasB = new Impresora[cantB];
        for (int j = 0; j < cantA; j++) {
            colImpresorasA[j] = new Impresora(j + 1, 'A');
        }
        for (int k = 0; k < cantB; k++) {
            colImpresorasB[k] = new Impresora(k + 1, 'B');
        }
    }

    public void buscar(int numero, char tipo) throws InterruptedException {
        boolean encontroA = false, encontroB = false;
        int i = 0;
        int j = 0;
        do {
            if (tipo == 'A') {
                Impresora impAux = colImpresorasA[i];
                encontroA = impAux.usar(numero);
                if (encontroA) {
                    //System.out.println(Thread.currentThread().getName() + " encontró impresora "+impAux.getId());
                    Thread.sleep(1000);
                    impAux.liberar(numero);
                    //System.out.println(Thread.currentThread().getName() + " liberó impresora "+impAux.getId());
                } else {
                    i = (i + 1) % colImpresorasA.length;
                }
            } else if(tipo == 'B'){
                Impresora impAuxB = colImpresorasB[j];
                encontroB = impAuxB.usar(numero);
                if (encontroB) {
                    //System.out.println(Thread.currentThread().getName() + " encontró impresora "+impAux.getId());
                    Thread.sleep(1000);
                    impAuxB.liberar(numero);
                    //System.out.println(Thread.currentThread().getName() + " liberó impresora "+impAux.getId());
                } else {
                    j = (j + 1) % colImpresorasB.length;
                }
            }

        } while (!encontroA && !encontroB);
    }
}
