package TP2.Ejercicio8;

/**
 *
 * @author Fran
 */
public class Main {
/* En la clase principal, crea un arreglo de objetos Corredor (instancias de
    la clase Corredor) y para cada corredor en el arreglo, crea un objeto Thread
    y pasar la instancia del corredor como argumento al constructor del Thread */
    public static void main(String[] args) {
        int i;
        Corredor[] corredores = new Corredor[10];
        Thread[] hilos = new Thread[10];
        for (i = 0; i < corredores.length; i++) {
            Corredor corredor = new Corredor("Corredor " + (i + 1), 0);
            corredores[i] = corredor;
        }
        for(i = 0; i < hilos.length; i++) {
            Thread hilo = new Thread(corredores[i]);
            hilos[i] = hilo;
        }
        for (i = 0; i < corredores.length; i++) {
            hilos[i].start();
        }
        try {
            for (i = 0; i < corredores.length; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException ex) {
        }
        Corredor mayorDistancia = buscar(corredores);
        System.out.println("El corredor que hizo la mayor distancia es el " + 
               mayorDistancia.getNombre() + " con " + mayorDistancia.getDistancia() + "m");
    }
    
    public static Corredor buscar(Corredor[] corredores) {
        Corredor aux = null;
        int i, distanciaAux = 0;
        for (i = 0; i < corredores.length; i++) {
            if (corredores[i].getDistancia() > distanciaAux) {
                distanciaAux = corredores[i].getDistancia();
                aux = corredores[i];
            }
        }
        return aux;
    }
}