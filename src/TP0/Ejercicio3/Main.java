package TP0.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Main {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Fran Llanquin", "Aca", "9/12/18", "Masculino", "FAI-3199", 11);
        System.out.println(empleado.toString());
        
        Empresa empresa = new Empresa();
        empresa.agregarEmpleado(empleado);
        System.out.println(empresa.antiguedadMayor10().toString());
    }
    
}
