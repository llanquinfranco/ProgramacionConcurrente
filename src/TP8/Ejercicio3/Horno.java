package TP8.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Horno extends Thread {

    private char tipo;
    private Mostrador mostrador;

    public Horno(char tipo, Mostrador mostrador) {
        this.tipo = tipo;
        this.mostrador = mostrador;
    }

    public void run() {
        while (true) {
            try {
                switch (tipo) {
                    case 'A':
                        mostrador.hornear(tipo, 15);
                        Thread.sleep(3000);
                        break;
                    case 'B':
                        mostrador.hornear(tipo, 20);
                        Thread.sleep(3000);
                        break;
                    case 'C':
                        mostrador.hornear(tipo, 25);
                        Thread.sleep(3000);
                        break;
                }
            } catch (Exception ex) {

            }
        }
    }

}
