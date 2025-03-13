package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personas {
    public static final long SEED = 0;
    public static final int TOTAL_PERSONAS = 50;

    public enum Genero { MASCULINO, FEMENINO }
    public record Persona(int edad, Genero genero) {}

    public static void main(String[] args) {
        List<Persona> personas = generarPersonasAleatorias(TOTAL_PERSONAS);
        mostrarEstadisticas(personas);
    }

    /**
     * Imprime las estadisticas de una lista de personas
     *
     * @param personas Lista de personas (50)
     */
    public static void mostrarEstadisticas(List<Persona> personas) {
        int totalMujeres = 0;
        int totalMayores = 0;
        int totalMenores = 0;
        int hombresMayores = 0;
        int mujeresMenores = 0;

        for (Persona persona : personas) {
            boolean esMujer = persona.genero == Genero.FEMENINO;
            boolean esMayor = persona.edad >= 18;
            
            if (esMujer) totalMujeres++;
            
            if (esMayor) {
                totalMayores++;
                if (!esMujer) hombresMayores++;
            } else {
                totalMenores++;
                if (esMujer) mujeresMenores++;
            }
        }

        System.out.println("Cantidad de personas mayores de edad (18 años o más): " + totalMayores);
        System.out.println("Cantidad de personas menores de edad: " + totalMenores);
        System.out.println("Cantidad de personas masculinas mayores de edad: " + hombresMayores);
        System.out.println("Cantidad de personas femeninas menores de edad: " + mujeresMenores);
        
        double porcentajeMayores = (double) totalMayores / TOTAL_PERSONAS * 100;
        double porcentajeMujeres = (double) totalMujeres / TOTAL_PERSONAS * 100;
        
        System.out.printf("Porcentaje que representan las personas mayores de edad: %.2f%%\n", porcentajeMayores);
        System.out.printf("Porcentaje que representan las mujeres: %.2f%%\n", porcentajeMujeres);
    }

    /**
     * Genera una lista de personas aleatorias.
     *
     * @param cantidad Cantidad de personas a generar
     * @return Lista de personas generadas
     */
    public static List<Persona> generarPersonasAleatorias(int cantidad) {
        List<Persona> personas = new ArrayList<>(cantidad);
        Random random = new Random(SEED);

        for (int i = 0; i < cantidad; i++) {
            Genero genero = random.nextBoolean() ? Genero.MASCULINO : Genero.FEMENINO;
            int edad = random.nextInt(80) + 1;
            personas.add(new Persona(edad, genero));
        }

        return personas;
    }
}
