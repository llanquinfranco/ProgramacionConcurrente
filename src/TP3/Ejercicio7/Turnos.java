package TP3.Ejercicio7;


/**
 *
 * @author Fran
 */
public class Turnos {
    
    private static char turno = 'A';    // Siempre la impresion arranca con 'A'
                                        // Recurso compartido para saber el turno

    public synchronized void imprimir(char caracter, int cantidad) throws InterruptedException {
        if (caracter == turno) {
            int j;
            for (j = 1; j <= cantidad; j++) {
                System.out.print(caracter);
                Thread.sleep(300);
            }
            cambiarTurno(caracter);
        }
    }

    private void cambiarTurno(char caracter) {
        switch (caracter) {
            case 'A':
                turno = 'B';
                break;
            case 'B':
                turno = 'C';
                break;
            case 'C':
                turno = 'A';
                break;
        }
    }
}