package ejercicio3;

import java.util.Scanner;

public class Sueldo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese las horas trabajadas: ");
        double horasTrabajadas = scanner.nextDouble();
        
        System.out.print("Ingrese la tarifa por hora: ");
        double tarifa = scanner.nextDouble();

        scanner.close();

        double sueldo = calcularSueldo(horasTrabajadas, tarifa);
        System.out.println("El sueldo del trabajador es: " + sueldo);
    }
    
    /**
     * Calcula el sueldo de un trabajador basado en las horas trabajadas y la tarifa.
     * Si las horas trabajadas superan las 40, las horas extras se pagan con un 50% adicional.
     * 
     * @param horasTrabajadas Número de horas trabajadas
     * @param tarifa Tarifa por hora normal
     * @return El sueldo total calculado
     */
    public static double calcularSueldo(double horasTrabajadas, double tarifa) {
        double sueldo;
        
        if (horasTrabajadas <= 40) {
            sueldo = horasTrabajadas * tarifa;
        } else {
            double horasNormales = 40;
            double horasExtras = horasTrabajadas - 40;
            double tarifaExtra = tarifa * 1.5;
            
            sueldo = (horasNormales * tarifa) + (horasExtras * tarifaExtra);
        }
        
        return sueldo;
    }
}
