package TP0.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Persona {
    /* Cada persona tiene informacion personal como nombre, DNI, 
    direccion, fecha de nacimiento y sexo */
    private String nombre;
    private String direccion;
    private String fechaNacimiento;
    private String sexo;
    
    public Persona(String nombre, String direccion, String fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Direccion: " + direccion + ", Fecha de Nacimiento: "
                + fechaNacimiento + ", Sexo: " + sexo;
    }
    
}
