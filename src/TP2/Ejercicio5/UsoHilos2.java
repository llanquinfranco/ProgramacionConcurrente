package TP2.Ejercicio5;

/**
 *
 * @author Fran
 */
class UsoHilos2 {

    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        //Primero, construye un objeto unHilo.
        MiHilo2 mh = new MiHilo2("#1");
        //Finalmente, comienza la ejecución del hilo.
        mh.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
