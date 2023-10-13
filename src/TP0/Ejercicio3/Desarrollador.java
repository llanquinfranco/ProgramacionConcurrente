package TP0.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Desarrollador extends Empleado{
    /* Los desarrolladores son empleados que poseen habilidades tecnicas y tienen un
    título que los avala. Los desarrolladores cobran un adicional basado en su rol */
    String titulo;
    
    public Desarrollador(String nombre, String direccion, String fechaNacimiento, String sexo,
            String legajo, int antiguedad, String titulo) {
        super(nombre, direccion, fechaNacimiento, sexo, legajo, antiguedad);
        this.titulo = titulo;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Titulo: " + titulo;
    }
}
