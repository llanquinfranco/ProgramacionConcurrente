package TP5.Ejercicio8;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        int cantIzquierda = 23, cantDerecha = 17;
        
        Cuerda cuerda = new Cuerda(cantIzquierda, cantDerecha);
        
        Babuino[] babuinosIzquierda = new Babuino[cantIzquierda];
        for(int i = 0; i < cantIzquierda; i++) {
            babuinosIzquierda[i] = new Babuino(i + 1, 'I', cuerda);
            babuinosIzquierda[i].start();
        }
        
        Babuino[] babuinosDerecha = new Babuino[cantDerecha];
        for(int j = 0; j < cantDerecha; j++) {
            babuinosDerecha[j] = new Babuino(cantDerecha + j + 1, 'D', cuerda);
            babuinosDerecha[j].start();
        }
        
        
    }
    
}
