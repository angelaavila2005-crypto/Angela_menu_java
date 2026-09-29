package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Integer> ListadoNumeros;
        ListadoNumeros = new ArrayList<>();
        int opcion = 0;
        while (opcion != 7) {
            opcion = menu();
            switch (opcion) {
                case 1:
                    leerDato(ListadoNumeros);
                    break;

                case 2:
                    numerosPares(ListadoNumeros);
                    break;

                case 3:
                    cuadrosValores(ListadoNumeros);
                    break;

                case 4:
                    int suma = sumaNumeros(ListadoNumeros);
                    System.out.println("La suma es: "+suma);
                    break;

                case 5:
                    buscarElemento(ListadoNumeros);
                    break;

                case 6:
                    valorMaximo(ListadoNumeros);
                    break;
            }
        }
    }

    public static int sumaNumeros(List<Integer> listado){
        int suma =0;
        for(int i=0; i<listado.size(); i++){
            suma = suma + listado.get(i);
        }
        return suma;
    }

    public static void numerosPares(List<Integer> listado){
        System.out.println("Numeros Pares: ");
        for(int i=0; i<listado.size();i++){
            if(listado.get(i) % 2 == 0){
                int numeroPar=listado.get(i);
                System.out.println(numeroPar);
            }
        }
    }

    public static void leerDato(List<Integer> listado){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digita un numero");
        int numero = sc.nextInt();
        listado.add(numero);
    }


    public static void cuadrosValores(List<Integer> listado) {
        System.out.println("Cuadrado de los valores: ");
        for (int i = 0; i < listado.size(); i++) {
            int valor = listado.get(i);
            int cuadro = valor * valor;
            System.out.println("El cuadrado de " + valor + " es: " + cuadro);
        }
    }

    public static void buscarElemento(List<Integer> listado) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digita el numero que deseas buscar:");
        int buscado = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i) == buscado) {
                System.out.println("El numero " + buscado + " se encontro en la posicion: " + i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El numero " + buscado + " no esta en la lista.");
        }
    }

    public static void valorMaximo(List<Integer> listado) {
        if (listado.isEmpty()) {
            System.out.println("La lista esta vacia");
            return;
        }

        int maximo = listado.get(0);
        for (int i = 1; i < listado.size(); i++) {
            if (listado.get(i) > maximo) {
                maximo = listado.get(i);
            }
        }
        System.out.println("El valor maximo de la lista es: " + maximo);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1,- Leer datos");
        System.out.println("2,- Muestre numero pares");
        System.out.println("3,- Muestre los cuadros de valores");
        System.out.println("4,- Suma de los elementos de la lista");
        System.out.println("5,- Buscar un elemento de la lista");
        System.out.println("6,- Encontrar el valor maximo");
        System.out.println("7,- Salir");
        int opcion = sc.nextInt();
        return opcion;
    }

}