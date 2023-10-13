package TP2.Ejercicio7;

/**
 *
 * @author Fran
 */
public class CajeroThread extends Thread {

    private final String nombre;
    private final Cliente cliente;
    private final long initialTime;
    // Constructor, y métodos de acceso
    // Agregar Constructor, y métodos de acceso
    public CajeroThread(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void run() {
        System.out.println("El cajero " + this.nombre
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " 
                    + this.cliente.getNombre() + "->Tiempo: " 
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " 
                + this.cliente.getNombre() + " EN EL TIEMPO: " 
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }
    
    public void esperarXsegundos(int numero) {
        try {
            Thread.sleep(numero * 1000);
        }catch(InterruptedException ex){
        }
    }
    
}
