package Parciales.Compania;

import java.util.Random;

/**
 *
 * @author franco.llanquin
 */
public class Socio extends Thread {

    Random r = new Random();
    private char tipo;
    private Compania compania;

    public Socio(String nombre, char tipo, Compania compania) {
        super(nombre);
        this.tipo = tipo;
        this.compania = compania;
    }

    public void run() {
        int numero;
        try {
            if (tipo == 'E') {
                while (true) {
                    numero = compania.seleccionarEspanol();
                    Thread.sleep(4000); // simula el tiempo que mira el capitulo
                    compania.terminarEspanol(numero);
                    Thread.sleep(3000); // cuando, termina de ver un capitulo, descansan un tiempo asi no esta viendo sin parar
                }
            } else if (tipo == 'I') {
                while (true) {
                    numero = compania.seleccionarIngles();
                    Thread.sleep(4000); // simula el tiempo que mira el capitulo
                    compania.terminarIngles(numero);
                    Thread.sleep(3000); // cuando, termina de ver un capitulo, descansan un tiempo asi no esta viendo sin parar
                }
            }
        } catch (InterruptedException ex) {
        }
    }

}
