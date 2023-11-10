package TP8.Ejercicio4;

/**
 *
 * @author Fran
 */
public class Donante extends Thread {
    
    private SalaDeEspera sala;
    
    public Donante(String nombre, SalaDeEspera sala) {
        super(nombre);
        this.sala = sala;
    }
    
    public void run() {
        try {
            sala.pedirCamilla();
            Thread.sleep(1500);
            sala.soltarCamilla();
        } catch(Exception ex) {
            
        }
    }
}
