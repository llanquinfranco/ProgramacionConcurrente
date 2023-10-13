package TP1.Ejercicio8;

import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class PruebaExcep {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        edadPersona();
        
    }

    
    public static void edadPersona() {
        /* Escriba un método que ingrese la edad de una persona y dispare una
        excepción si la persona es menor de edad */
        int edad;
        System.out.println("Ingrese la edad de una persona X");
        edad = sc.nextInt();
        if (edad >= 18) {
            System.out.println("La persona es mayor de edad");
        } else {
            throw new ArithmeticException("La persona es menor de edad");
        }
    }
}
