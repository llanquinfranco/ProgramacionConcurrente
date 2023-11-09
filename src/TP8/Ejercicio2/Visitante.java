package TP8.Ejercicio2;

/**
 *
 * @author Fran
 */
public class Visitante extends Thread{
    
    private Observatorio observatorio;
    private boolean esDiscapacitado;
    
    public Visitante(String nombre, boolean esDiscapacitado, Observatorio observatorio) {
        super(nombre);
        this.esDiscapacitado = esDiscapacitado;
        this.observatorio = observatorio;
    }
    
    public void run() {
        try {
            if(!esDiscapacitado) {
                observatorio.entrarPersona();
                Thread.sleep(4000);
                observatorio.salirPersona();
            } else {
                observatorio.entrarDiscapacitado();
                Thread.sleep(4000);
                observatorio.salirDiscapacitado();
            }
        }catch(Exception ex) {
            
        }
    }
    
    
    
    
}
