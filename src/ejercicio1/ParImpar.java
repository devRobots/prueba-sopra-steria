package ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Ejercicio 1.
 * Determinar si un numero es par o impar
 *
 * @author Yesid Rosas <ysrosast@gmail.com>
 */
public class ParImpar {
    public static void main(String[] args) {
        System.out.print("LEER NUMERO: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        isEvenOdd(number);
    }

    /**
     * Imprime si un numero es par o impar.
     * Si el numero es par muestra una lista con todos los pares descendentes hasta 0.
     * Si el numero es impar muestra una lista con todos los impares descendentes hasta 1.
     *
     * @param number Numero entero
     */
    public static void isEvenOdd(int number) {
        boolean even = number % 2 == 0;
        System.out.print(even ? "PAR" : "IMPAR");

        List<Integer> numerosDesc = new ArrayList<>();
        for (int i = number; i >= 0; i--) {
            if (even && i % 2 != 0) { continue; }
            if (!even && i % 2 == 0) { continue; }
            numerosDesc.add(i);
        }
        System.out.println(" " + Arrays.toString(numerosDesc.toArray()));
    }
}
