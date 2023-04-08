package com.oterors;

public class App {
    public static void main( String[] args ) {
        final int BOARD_SIZE = 8;
        Board b = new Board(BOARD_SIZE);
        System.out.println("Resultado passeio " + BOARD_SIZE + " x " + BOARD_SIZE + ": " + b.knightTour(0, 0));
      
        int[][] maxBoard = b.getMaxBoard();
        for (int i = BOARD_SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.printf("%02d ", maxBoard[i][j]);
            }
            System.out.println();
        }
    }
}
