package com.oterors;
/*
import java.awt.Point;
import java.util.ArrayList;
*/
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
/*
        Board b = new Board(4);
        b.set(1, 1);
        System.out.println(b.isFull());
        ArrayList<Point> moves = b.getMoves();
        for (Point point : moves) {
            System.out.println(point.toString());
        }
*/
        Board b = new Board(8);
        System.out.println("Resultado passeio 8 x 8: " + b.knightTour(0, 0));
        System.out.println("Max filled: " + b.getMaxFilled());
      
        int[][] maxBoard = b.getMaxBoard();
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%02d ", maxBoard[i][j]);
            }
            System.out.println();
        }

    }
}
