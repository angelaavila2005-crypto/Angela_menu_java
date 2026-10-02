import java.util.Arrays;
import java.util.Comparator;

public class EjerciciosStream {

    //repositorio: 

    public static void main(String[] args) {
        int[] numeros = {12, 45, 7, 88, 53, 20, 3, 61, 50, 99, -4};
        double[] celsius = {0, 25, 37, 100};
        String[] nombres = {"Ana", "Carlos", "Beatriz", "Luis", "Fernanda", "Pedro", "Alberto"};

        System.out.println("Arreglo: " + Arrays.toString(numeros));
        System.out.println("Nombres: " + Arrays.toString(nombres));

        // NIVEL 1 - Operaciones básicas
        System.out.println("1. Suma: " + Arrays.stream(numeros).sum());
        System.out.println("2. Máximo: " + Arrays.stream(numeros).max().getAsInt());
        System.out.println("3. Mínimo: " + Arrays.stream(numeros).min().getAsInt());
        System.out.println("4. Cantidad: " + Arrays.stream(numeros).count());

        // NIVEL 2 - filter
        System.out.println("5. Pares: " + Arrays.toString(
                Arrays.stream(numeros).filter(n -> n % 2 == 0).toArray()));
        System.out.println("6. Mayores que 50: " + Arrays.toString(
                Arrays.stream(numeros).filter(n -> n > 50).toArray()));
        System.out.println("7. Cantidad de positivos: " +
                Arrays.stream(numeros).filter(n -> n > 0).count());
        System.out.println("8. Entre 10 y 60: " + Arrays.toString(
                Arrays.stream(numeros).filter(n -> n >= 10 && n <= 60).toArray()));

        // NIVEL 3 - map
        System.out.println("9. Al cuadrado: " + Arrays.toString(
                Arrays.stream(numeros).map(n -> n * n).toArray()));
        System.out.println("10. Por 10: " + Arrays.toString(
                Arrays.stream(numeros).map(n -> n * 10).toArray()));
        System.out.println("11. Celsius a Fahrenheit: " + Arrays.toString(
                Arrays.stream(celsius).map(c -> c * 9 / 5 + 32).toArray()));

        // NIVEL 4 - combinar operaciones
        System.out.println("12. Pares al cuadrado: " + Arrays.toString(
                Arrays.stream(numeros).filter(n -> n % 2 == 0).map(n -> n * n).toArray()));
        System.out.println("13. Suma de pares: " +
                Arrays.stream(numeros).filter(n -> n % 2 == 0).sum());
        System.out.println("14. Promedio de mayores que 50: " +
                Arrays.stream(numeros).filter(n -> n > 50).average().orElse(0));
        System.out.println("15. Máximo de pares: " +
                Arrays.stream(numeros).filter(n -> n % 2 == 0).max().orElse(0));

        // NIVEL 5 - ordenamiento
        System.out.println("16. Menor a mayor: " + Arrays.toString(
                Arrays.stream(numeros).sorted().toArray()));
        System.out.println("17. Mayor a menor: " + Arrays.toString(
                Arrays.stream(numeros).boxed()
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(Integer::intValue).toArray()));
        System.out.println("18. Tres más grandes: " + Arrays.toString(
                Arrays.stream(numeros).boxed()
                        .sorted(Comparator.reverseOrder())
                        .limit(3)
                        .mapToInt(Integer::intValue).toArray()));

        // NIVEL 6 - String[]
        System.out.println("19. Nombres que empiezan con A: " + Arrays.toString(
                Arrays.stream(nombres).filter(s -> s.startsWith("A")).toArray(String[]::new)));
        System.out.println("20. Más de 5 caracteres: " + Arrays.toString(
                Arrays.stream(nombres).filter(s -> s.length() > 5).toArray(String[]::new)));
        System.out.println("21. Mayúsculas: " + Arrays.toString(
                Arrays.stream(nombres).map(String::toUpperCase).toArray(String[]::new)));
        System.out.println("22. Ordenados: " + Arrays.toString(
                Arrays.stream(nombres).sorted().toArray(String[]::new)));

        // NIVEL 7
        int buscado = 45;
        System.out.println("23. ¿Está el " + buscado + "? " +
                Arrays.stream(numeros).anyMatch(n -> n == buscado));
        System.out.println("24. ¿Todos son positivos? " +
                Arrays.stream(numeros).allMatch(n -> n > 0));
        System.out.println("25. ¿Alguno es par? " +
                Arrays.stream(numeros).anyMatch(n -> n % 2 == 0));
    }
}
