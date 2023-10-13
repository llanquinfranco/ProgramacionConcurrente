package TP0.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Empleado extends Persona {
    /* Un empleado es una persona que desempeña una funcion en alguna Empresa y 
    recibe un salario por ello. Todos los empleados tienen un legajo y cobran un
    porcentaje por antigüedad */
    private String legajo;
    private int antiguedad;
    
    public Empleado(String nombre, String direccion, String fechaNacimiento, String sexo,
            String legajo, int antiguedad) {
        super(nombre, direccion, fechaNacimiento, sexo);
        this.legajo = legajo;
        this.antiguedad = antiguedad;
    }
    
    public int getAntiguedad() {
        return antiguedad;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Legajo: " + legajo + ", Antiguedad: " + antiguedad;
    }
    
}
