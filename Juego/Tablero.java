package Juego;

public class Tablero {
    private char[][] matriz;

    /**
     * Inicializa una matriz de simbolos para representar el tablero con el número
     * especificado de filas y columnas. Inicializa cada celda del tablero con
     * espacio (' ').
     *
     * @param filas    Número de filas en el tablero.
     * @param columnas Número de columnas en el tablero.
     */
    public Tablero(int filas, int columnas) {
        matriz = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    /**
     * Método para mostrar visualmente el tablero en la consola.
     * Imprime las celdas del tablero con sus respectivos símbolos ('X', 'O' o espacio en blanco),
     * separadas por líneas y columnas, y muestra un indicador numérico de las columnas en la parte inferior.
     */
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

    /**
     * metodo para colocar ficha jugador por jugador
     *
     * @param jugador Jugador que coloca la ficha.
     * @param columna Número de columna en la que se intenta colocar la ficha.
     * @return true si la ficha se colocó con éxito, false si la columna está llena.
     */
    public boolean colocarFicha(Jugador jugador, int columna) {
        boolean fichaColocada = false;

        for (int i = matriz.length - 1; i >= 0 && !fichaColocada; i--) {
            if (matriz[i][columna] == ' ') {
                matriz[i][columna] = jugador.getSimbolo();
                fichaColocada = true;
            }
        }

        return fichaColocada;
    }

    /**
     * metodo que devuelve el ganador
     *
     * @param jugador jugador que gana la partida si es X u O
     * @return devuelve true si se cumplen uno de los parametros colocados
     */
    public boolean hayGanador(Jugador jugador) {
        boolean ganadorHorizontal = verificarGanadorHorizontal(jugador);
        boolean ganadorDiagonalDerecha = verificarGanadorDiagonalDerecha(jugador);
        boolean ganadorDiagonalIzquierda = verificarGanadorDiagonalIzquierda(jugador);
        boolean GanadorVertical = verificarGanadorVertical(jugador);

        // Devuelve true si al menos una dirección es ganadora
        return ganadorHorizontal || ganadorDiagonalDerecha || ganadorDiagonalIzquierda || GanadorVertical;
    }

    /**
     * Verifica si hay un ganador en sentido horizontal para el jugador especificado.
     *
     * @param jugador Jugador para el cual se verifica la condición de ganador horizontal.
     * @return true si el jugador es ganador en sentido horizontal, false en caso contrario.
     */
    private boolean verificarGanadorHorizontal(Jugador jugador) {
        boolean ganadorHorizontal = false;

        for (int i = 0; i < matriz.length && !ganadorHorizontal; i++) {
            for (int j = 0; j < matriz[i].length - 3; j++) {
                if (matriz[i][j] == jugador.getSimbolo() &&
                        matriz[i][j + 1] == jugador.getSimbolo() &&
                        matriz[i][j + 2] == jugador.getSimbolo() &&
                        matriz[i][j + 3] == jugador.getSimbolo()) {
                    ganadorHorizontal = true;
                }
            }
        }

        return ganadorHorizontal;
    }

    /**
     * Verifica si hay un ganador en sentido vertical para el jugador especificado.
     *
     * @param jugador Jugador para el cual se verifica la condición de ganador horizontal.
     * @return true si el jugador es ganador en sentido horizontal, false en caso contrario.
     */
    private boolean verificarGanadorVertical(Jugador jugador) {
        boolean ganadorVertical = false;

        for (int j = 0; j < matriz[0].length && !ganadorVertical; j++) {
            for (int i = 0; i <= matriz.length - 4 && !ganadorVertical; i++) {
                // Verificar si hay cuatro fichas consecutivas del mismo jugador en una columna
                ganadorVertical = (matriz[i][j] == jugador.getSimbolo() &&
                        matriz[i + 1][j] == jugador.getSimbolo() &&
                        matriz[i + 2][j] == jugador.getSimbolo() &&
                        matriz[i + 3][j] == jugador.getSimbolo());
            }
        }

        return ganadorVertical;
    }

    /**
     * Verifica si hay un ganador en diagonal derecha para el jugador especificado.
     *
     * @param jugador Jugador para el cual se verifica la condición de ganador horizontal.
     * @return true si el jugador es ganador en sentido horizontal, false en caso contrario.
     */
    private boolean verificarGanadorDiagonalDerecha(Jugador jugador) {
        boolean ganadorDiagonalDerecha = false;

        // Verificar diagonalmente (de izquierda a derecha)
        for (int i = 0; i < matriz.length && !ganadorDiagonalDerecha; i++) {
            for (int j = 0; j < matriz[i].length && !ganadorDiagonalDerecha; j++) {
                if (i + 3 < matriz.length && j + 3 < matriz[i].length &&
                        (matriz[i][j] == jugador.getSimbolo() &&
                                matriz[i + 1][j + 1] == jugador.getSimbolo() &&
                                matriz[i + 2][j + 2] == jugador.getSimbolo() &&
                                matriz[i + 3][j + 3] == jugador.getSimbolo())) {
                    ganadorDiagonalDerecha = true;
                }
            }
        }

        return ganadorDiagonalDerecha;
    }

    /**
     * Verifica si hay un ganador en diagonal izquierda para el jugador especificado.
     *
     * @param jugador Jugador para el cual se verifica la condición de ganador horizontal.
     * @return true si el jugador es ganador en sentido horizontal, false en caso contrario.
     */
    private boolean verificarGanadorDiagonalIzquierda(Jugador jugador) {
        boolean ganadorDiagonalIzquierda = false;

        for (int i = 0; i < matriz.length - 3 && !ganadorDiagonalIzquierda; i++) {
            for (int j = 3; j < matriz[i].length; j++) {
                if (matriz[i][j] == jugador.getSimbolo() &&
                        matriz[i + 1][j - 1] == jugador.getSimbolo() &&
                        matriz[i + 2][j - 2] == jugador.getSimbolo() &&
                        matriz[i + 3][j - 3] == jugador.getSimbolo()) {
                    ganadorDiagonalIzquierda = true;
                }
            }
        }

        return ganadorDiagonalIzquierda;
    }


    /**
     * metodo que dice en todo momento si el tablero esta o no lleno
     *
     * @return devuelve si el tablero esta lleno y termina el juego
     */
    public boolean estaLleno() {
        boolean hayEspacioEnBlanco = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == ' ') {
                    hayEspacioEnBlanco = true;

                }
            }
        }

        // Devuelve true si no hay espacios en blanco (tablero lleno), false de lo contrario
        return !hayEspacioEnBlanco;
    }
}
