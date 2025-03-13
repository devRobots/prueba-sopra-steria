import ejercicio1.ParImpar;
import ejercicio2.Personas;
import ejercicio3.Sueldo;
import ejercicio4.Alimentacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) Par/Impar");
        System.out.println("2) Personas");
        System.out.println("3) Sueldo");
        System.out.println("4) Alimentacion");
        System.out.print("Seleccione un ejercicio: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        switch (number) {
            case 1: ParImpar.main(args); break;
            case 2: Personas.main(args); break;
            case 3: Sueldo.main(args); break;
            case 4: Alimentacion.main(args); break;
            default: System.err.println("ERROR: El ejercicio seleccionado no existe");
        }
    }
}