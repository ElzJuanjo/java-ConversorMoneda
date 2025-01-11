package src;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Api api = new Api();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        double cantidad = 0.0;
        double resultado = 0.0;

        while (opcion != 7) {
            System.out.println("Menu de Conversiones de Monedas");
            System.out.println("1. Peso Colombiano a Dólar Estadounidense");
            System.out.println("2. Peso Colombiano a Peso Mexicano");
            System.out.println("3. Dólar Estadounidense a Peso Colombiano");
            System.out.println("4. Dólar Estadounidense a Peso Mexicano");
            System.out.println("5. Peso Mexicano a Peso Colombiano");
            System.out.println("6. Peso Mexicano a Dólar Estadounidense");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion > 0 && opcion < 7) {
                    System.out.print("Ingresa la cantidad a convertir: ");
                    cantidad = Double.parseDouble(scanner.nextLine());
                }
            } catch (NumberFormatException e) {
                opcion = 0;
                System.out.println("Debes ingresar un número.");
            }

            switch (opcion) {
                case 1 -> {
                    resultado = api.convertir("COP", "USD", cantidad);
                }
                case 2 -> {
                    resultado = api.convertir("COP", "MXN", cantidad);
                }
                case 3 -> {
                    resultado = api.convertir("USD", "COP", cantidad);
                }
                case 4 -> {
                    resultado = api.convertir("USD", "MXN", cantidad);
                }
                case 5 -> {
                    resultado = api.convertir("MXN", "COP", cantidad);
                }
                case 6 -> {
                    resultado = api.convertir("MXN", "USD", cantidad);
                }
                case 7 -> {
                    System.out.println("Programa terminado.\nDEV: Juan José JV");
                }
                default ->
                    System.out.println("Opción no válida.");
            }

            if (opcion > 0 && opcion < 7) {
                System.out.println("Resultado: " + resultado);
            }

            System.out.println("\nPresiona enter para continuar...");
            try {
                System.in.read();
                scanner.nextLine();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
