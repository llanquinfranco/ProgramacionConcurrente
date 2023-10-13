package TP2.Ejercicio7;

/**
 *
 * @author Fran
 */
public class Cajero {
    
    private final String nombre;
    // Agregar Constructor, y métodos de acceso
    public Cajero(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA"
                + " COMPRA DEL CLIENTE " + cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + "->Tiempo: " 
                    + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR "
                + cliente.getNombre() + " EN EL TIEMPO: " + 
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }
    
    public void esperarXsegundos(int numero) {
        try {
            Thread.sleep(numero * 1000);
        }catch(InterruptedException ex) {
        }
    }
    
    
}
