package TP5.Ejercicio6;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        int cantDespegues = 5, cantAterrizajes = 23;
        Pista pista = new Pista(cantDespegues, cantAterrizajes, 'D');
        
        Torre torre = new Torre(pista);
        torre.start();
        
        Avion[] avionesADespegar = new Avion[cantDespegues];
        for(int i = 0; i < cantDespegues; i++) {
            avionesADespegar[i] = new Avion (i + 1, 'D', pista);
            avionesADespegar[i].start();
        }
        
        Avion[] avionesAAterrizar = new Avion[cantAterrizajes];
        for(int j = 0; j < cantAterrizajes; j++) {
            avionesAAterrizar[j] = new Avion(j + 1, 'A', pista);
            avionesAAterrizar[j].start();
        }
        
        
        
    }
    
}
