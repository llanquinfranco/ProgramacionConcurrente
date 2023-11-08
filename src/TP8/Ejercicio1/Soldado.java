package TP8.Ejercicio1;

/**
 *
 * @author Fran
 */
public class Soldado extends Thread {

    private int tipo;
    private Comedor comedor;

    public Soldado(String nombre, int tipo, Comedor comedor) {
        super(nombre);
        this.tipo = tipo;
        this.comedor = comedor;
    }

    public void run() {
        try {
            switch (tipo) {
                case 0:
                    // Toma agua y no pide postre
                    comedor.pedirBandeja();
                    break;
                case 1:
                    // Toma gaseosa y no pide postre
                    comedor.pedirBandeja();
                    comedor.pedirGaseosa();
                    break;
                case 2:
                    // Toma agua y pide postre
                    comedor.pedirBandeja();
                    comedor.pedirPostre();
                    break;
                case 3:
                    // Toma gaseosa y pide postre
                    comedor.pedirBandeja();
                    comedor.pedirGaseosa();
                    comedor.pedirPostre();
                    break;
            }
            Thread.sleep(4000); // Simulo el tiempo que tarda en comer
            comedor.devolverBandeja();
        } catch (Exception ex) {

        }

    }

}
