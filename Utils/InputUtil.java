package Utils;

import java.util.Scanner;

public class InputUtil {

    /**
     * Solicita al usuario que elija una columna para colocar una ficha en el tablero.
     *
     * @param scanner Scanner para la entrada de simbolos (X - O).
     * @return La columna seleccionada por el usuario (índice 1-7).
     */
    public static Scanner scanner = new Scanner(System.in);

    public static int solicitarColumna(Scanner scanner) {
        int columna;
        while (true) {
            try {
                System.out.print("Elige una columna (1-7): ");
                columna = Integer.parseInt(InputUtil.scanner.nextLine()) - 1;

                if (columna >= 0 && columna <= 6) {
                    return columna;
                } else {
                    System.out.println("Por favor, elige una columna válida (1-7).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        }
    }
}
