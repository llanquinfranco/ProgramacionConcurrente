package TP0.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Administrativo extends Empleado{
    /* Los empleados administrativos reciben un adicional de acuerdo a su 
    categoria y tambien tienen un adicional por asistencia */
    char categoria;
    int asistencia;
    
    public Administrativo(String nombre, String direccion, String fechaNacimiento, String sexo,
            String legajo, int antiguedad, char categoria, int asistencia) {
        super(nombre, direccion, fechaNacimiento, sexo, legajo, antiguedad);
        this.categoria = categoria;
        this.asistencia = asistencia;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Categoria: " + categoria + ", Porcentaje "
                + "asistencia: " + asistencia + "%";
    }
}
