package TP8.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Investigador extends Thread {
    
    private Observatorio observatorio;
    
    public Investigador(String nombre, Observatorio observatorio) {
        super(nombre);
        this.observatorio = observatorio;
    }
    
    public void run() {
        try {
            observatorio.entrarInvestigador();
            //Thread.sleep(5000);
            observatorio.salirInvestigador();
        } catch (Exception ex) {

        }
    }
}