package TP6.Ejercicio3;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Estudiante extends Thread {
    
    private Sala sala;
    
    public Estudiante(String nombre, Sala sala) {
        super(nombre);
        this.sala = sala;
    }
    
    public void run() {
        Random random = new Random();
        try {
            sala.entrar();
            Thread.sleep(random.nextInt(1001) + 1000);
            sala.salir();
        } catch(Exception ex) {
            
        }
    }
    
}
