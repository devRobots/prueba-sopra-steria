package ejercicio4;

import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Alimentacion {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("src/alimentacion.json");
            Object o = new JSONParser().parse(fr);
            JSONArray jsonArray = (JSONArray) o;

            imprimirAlimentosPorCategoria(jsonArray);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Imprime los alimentos por categoría.
     * Si un alimento esta repetido se mostrara unicamente una vez en la lista
     * Ademas cada alimento tendra un numero que corresponde a la cantidad de repeticiones de ese alimento.
     * 
     * @param alimentos Lista de alimentos en formato JSON
     */
    public static void imprimirAlimentosPorCategoria(JSONArray alimentos) {
        Map<String, Map<String, Integer>> categorias = new HashMap<>();

        for (Object item : alimentos) {
            JSONObject alimento = (JSONObject) item;
            String categoria = (String) alimento.get("categoría");
            String nombre = (String) alimento.get("nombre");

            if (!categorias.containsKey(categoria)) {
                categorias.put(categoria, new HashMap<>());
            }
            if (!categorias.get(categoria).containsKey(nombre)) {
                categorias.get(categoria).put(nombre, 0);
            }

            categorias.get(categoria).compute(nombre, (k, cant) -> cant + 1);
        }

        System.out.println("Alimentos por categoría:");
        for (String categoria : categorias.keySet()) {
            System.out.println("\n" + categoria + ":");
            for (String nombre : categorias.get(categoria).keySet()) {
                int cantidad = categorias.get(categoria).get(nombre);
                System.out.println("- " + nombre + ": " + cantidad);
            }
        }
    }
}
