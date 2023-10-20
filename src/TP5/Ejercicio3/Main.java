package TP5.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        int i, cantPerros = 20, cantGatos = 17; 
        
        Comedor comedor = new Comedor(5, 'P', cantPerros, cantGatos);
        
        Perro[] perros = new Perro[cantPerros];
        Gato[] gatos = new Gato[cantGatos];
        for(i = 0 ; i < cantPerros; i++) {
            perros[i] = new Perro(i + 1, comedor);
            perros[i].start();
        }
        for(i = 0; i < cantGatos; i++) {
            gatos[i] = new Gato(i + 1, comedor);
            gatos[i].start();
        }
        
    }
    
}
