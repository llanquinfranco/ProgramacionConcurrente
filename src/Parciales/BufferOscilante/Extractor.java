package Parciales.BufferOscilante;

import java.util.Random;

/**
 *
 * @author Fran
 */
public class Extractor extends Thread {

    Random random = new Random();
    private Buffer buffer;

    public Extractor(String nombre, Buffer buffer) {
        super(nombre);
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.extraer();
                Thread.sleep(random.nextInt(1000, 2000));
            } catch (Exception ex) {

            }
        }
    }
}
