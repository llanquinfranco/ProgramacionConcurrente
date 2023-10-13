package TP0.Ejercicio3;

import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public class Empresa {
    // Generar una coleccion con los empleados con antigüedad mayor a 10 años
    private ArrayList<Empleado> colEmpleados;
    
    public Empresa(){
        colEmpleados = new ArrayList();
    }
    
    public void agregarEmpleado(Empleado empleado) {
        colEmpleados.add(empleado);
    }
    
    public ArrayList antiguedadMayor10() {
        // Generar una coleccion con los empleados con antigüedad mayor a 10 años
        ArrayList lista = new ArrayList();
        int i;
        for(i = 0; i < colEmpleados.size(); i++) {
            if(colEmpleados.get(i).getAntiguedad() > 10) {
                lista.add(colEmpleados.get(i));
            }
        }
        return lista;
    }
    
    
}
