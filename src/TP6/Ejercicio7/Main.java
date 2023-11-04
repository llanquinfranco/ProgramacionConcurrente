package TP6.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Ferry ferry = new Ferry (10);
        
        ControlFerry control = new ControlFerry(ferry);
        control.start();
        
        Pasajero[] pasajeros = new Pasajero[30];
        for(int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero("Pasajero " + (i + 1), ferry);
            pasajeros[i].start();
        }
        
        Automovil[] automoviles = new Automovil[10];
        for(int j = 0; j < automoviles.length; j++) {
            automoviles[j] = new Automovil("Automovil " + (j + 1), 2, ferry);
            automoviles[j].start();
        }
    }
    
}
