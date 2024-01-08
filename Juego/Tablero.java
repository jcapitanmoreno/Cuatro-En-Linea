package Juego;

public class Tablero {
    private char[][] matriz;

    // Constructor que inicializa el tablero con espacios en blanco
    public Tablero(int filas, int columnas) {
        matriz = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    // Mostrar el tablero en la consola
    public void mostrar() {
        System.out.println("--------------");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j] + " |");
            }
            System.out.println();
            System.out.println("--------------");
        }
        System.out.println("  1   2   3   4   5   6   7 ");
    }

    // Colocar una ficha en la columna seleccionada
    public boolean colocarFicha(Jugador jugador, int columna) {
        for (int i = matriz.length - 1; i >= 0; i--) {
            if (matriz[i][columna] == ' ') {
                matriz[i][columna] = jugador.getSimbolo();
                return true;
            }
        }
        return false; // Columna llena
    }

    // Verificar si hay un ganador
    public boolean hayGanador(Jugador jugador) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j + 3 < matriz[i].length &&
                        (matriz[i][j] == jugador.getSimbolo() &&
                                matriz[i][j + 1] == jugador.getSimbolo() &&
                                matriz[i][j + 2] == jugador.getSimbolo() &&
                                matriz[i][j + 3] == jugador.getSimbolo())) {
                    return true; // Ganador horizontal
                }

                if (i + 3 < matriz.length &&
                        (matriz[i][j] == jugador.getSimbolo() &&
                                matriz[i + 1][j] == jugador.getSimbolo() &&
                                matriz[i + 2][j] == jugador.getSimbolo() &&
                                matriz[i + 3][j] == jugador.getSimbolo())) {
                    return true; // Ganador vertical
                }
            }
        }

        // Verificar diagonalmente (de izquierda a derecha)
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i + 3 < matriz.length && j + 3 < matriz[i].length &&
                        (matriz[i][j] == jugador.getSimbolo() &&
                                matriz[i + 1][j + 1] == jugador.getSimbolo() &&
                                matriz[i + 2][j + 2] == jugador.getSimbolo() &&
                                matriz[i + 3][j + 3] == jugador.getSimbolo())) {
                    return true; // Ganador diagonal
                }
            }
        }

        // Verificar diagonalmente (de derecha a izquierda)
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i + 3 < matriz.length && j - 3 >= 0 &&
                        (matriz[i][j] == jugador.getSimbolo() &&
                                matriz[i + 1][j - 1] == jugador.getSimbolo() &&
                                matriz[i + 2][j - 2] == jugador.getSimbolo() &&
                                matriz[i + 3][j - 3] == jugador.getSimbolo())) {
                    return true; // Ganador diagonal
                }
            }
        }

        return false; // No hay ganador

    }

    // Verificar si el tablero está lleno (empate)
    public boolean estaLleno() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == ' ') {
                    return false; // Todavía hay espacio en blanco
                }
            }
        }
        return true; // Tablero lleno
    }
}
