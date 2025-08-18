package principal;

import service.*;

import java.util.Scanner;

public class Principal {
    private final Conversion conversion = new Conversion();
    private final Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("****************************************************");
            System.out.println("Bienvenido/a al conversor de Monedas!");
            System.out.println("Selecciona la opción deseada por favor:");
            System.out.println("\n1) USD ==> Peso Argentino");
            System.out.println("2) Peso Argentino ==> USD");
            System.out.println("3) USD ==> Real Brasileño");
            System.out.println("4) Real Brasileño ==> USD");
            System.out.println("5) USD ==> Peso Colombiano");
            System.out.println("6) Peso Colombiano ==> USD");
            System.out.println("7) USD ==> Peso Mexicano");
            System.out.println("8) Peso Mexicano ==> USD");
            System.out.println("9) Salir");
            System.out.println("*****************************************************");
            System.out.print("Elija una opción válida: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1 -> convertir(Moneda.USD, Moneda.ARS);
                    case 2 -> convertir(Moneda.ARS, Moneda.USD);
                    case 3 -> convertir(Moneda.USD, Moneda.BRL);
                    case 4 -> convertir(Moneda.BRL, Moneda.USD);
                    case 5 -> convertir(Moneda.USD, Moneda.COP);
                    case 6 -> convertir(Moneda.COP, Moneda.USD);
                    case 7 -> convertir(Moneda.USD, Moneda.MXN);
                    case 8 -> convertir(Moneda.MXN, Moneda.USD);
                    case 9 -> System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    default -> System.out.println("Opción no válida. Inténtalo nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                opcion = -1; // Vuelve al menú
            }

        } while (opcion != 9);
    }

    private void convertir(Moneda moneda, Moneda monedaConvertida) {
        System.out.print("Ingrese el valor que desea convertir: ");
        try {
            double cantidad = Double.parseDouble(teclado.nextLine());
            double resultado = conversion.convertirMoneda(moneda.getCodigo(), monedaConvertida.getCodigo(), cantidad);
            System.out.printf("El valor de %.2f [%s] corresponde a ==>>> %.2f [%s]%n%n", cantidad, moneda, resultado, monedaConvertida);
        } catch (NumberFormatException e) {
            System.out.println("Valor no válido. Debe ser un número.");
        }
    }

    public static void main(String[] args) {
        new Principal().mostrarMenu();
    }
}