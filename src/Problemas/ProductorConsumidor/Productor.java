package Problemas.ProductorConsumidor;

/**
 *
 * @author Fran
 */
public class Productor extends Thread{

    private Buffer bufon;
    private int cantidad;
    private String nombre;

    public Productor(Buffer bufon,int cantidad,String nombre) {
        this.bufon = bufon;
        this.cantidad =cantidad;
        this.nombre=nombre;
    }

    
    public void run() {
       // while(true) {
            try {
                
                
                if (bufon.puedeAgregar(cantidad)) {
                    bufon.agregar(cantidad,nombre);
                }
            } catch (Exception ex) {
            }
     //   }
        
    }

}
