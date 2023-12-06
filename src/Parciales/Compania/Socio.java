package Parciales.Compania;

/**
 *
 * @author Fran
 */
public class Socio extends Thread {

    private char tipo;
    private Compania compania;

    public Socio(String nombre, char tipo, Compania compania) {
        super(nombre);
        this.tipo = tipo;
        this.compania = compania;
    }

    public void run() {
        while (true) {
            try {
                if (tipo == 'E') {
                    int numero = compania.verEspanol();
                    Thread.sleep(1500);
                    compania.terminarEspanol(numero);
                } else if (tipo == 'I') {
                    int numero = compania.verIngles();
                    Thread.sleep(1500);
                    compania.terminarIngles(numero);
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
