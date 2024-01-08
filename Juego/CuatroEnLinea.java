package Juego;

import Utils.InputUtil;

import java.util.Scanner;

public class CuatroEnLinea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tamaño del tablero
        int filas = 6;
        int columnas = 7;

        // Crear el tablero
        Tablero tablero = new Tablero(filas, columnas);

        // Jugadores
        Jugador jugadorX = new Jugador('X');
        Jugador jugadorO = new Jugador('O');

        // Jugador actual
        Jugador jugadorActual = jugadorX;

        // Bucle principal del juego
        while (true) {
            // Mostrar el tablero
            tablero.mostrar();

            // Solicitar al jugador que elija una columna
            int columna = InputUtil.solicitarColumna(scanner);

            // Colocar la ficha en la columna seleccionada
            if (!tablero.colocarFicha(jugadorActual, columna)) {
                System.out.println("Columna llena. Elige otra.");
                continue;
            }

            // Verificar si hay un ganador
            if (tablero.hayGanador(jugadorActual)) {
                tablero.mostrar();
                System.out.println("¡Jugador " + jugadorActual.getSimbolo() + " gana!");
                break;
            }

            // Verificar empate
            if (tablero.estaLleno()) {
                tablero.mostrar();
                System.out.println("Empate. El tablero está lleno.");
                break;
            }

            // Cambiar al siguiente jugador
            jugadorActual = (jugadorActual == jugadorX) ? jugadorO : jugadorX;
        }

        scanner.close();
    }
}
