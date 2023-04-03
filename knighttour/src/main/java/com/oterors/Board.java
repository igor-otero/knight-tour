package com.oterors;

import java.awt.Point;
import java.util.ArrayList;

public class Board {
    static int bSize;
    static int[][] board;
    static int[][] maxBoard;
    static int filled = 0;
    static int maxFilled = 0;
    static ArrayList<Point> sequence;
    static Point relativeMoves[] = {
        new Point(-2, -1),
        new Point(-2, 1),
        new Point(-1, -2),
        new Point(-1, 2),
        new Point(1, -2),
        new Point(1, 2),
        new Point(2, -1),
        new Point(2, 1)
    };

    public Board(int boardSize) {
        bSize = boardSize;
        board = new int[bSize][bSize];
        for (int i = 0; i < bSize; i++) {
            for (int j = 0; j < bSize; j++) {
                board[i][j] = 0;
            }
        }
        sequence = new ArrayList<Point>();
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getMaxBoard() {
        return maxBoard;
    }

    public int getMaxFilled() {
        return maxFilled;
    }

    public void set(int x, int y) {
        board[x][y] = ++filled;
        Point p = new Point(x, y);
        sequence.add(p);
    }

    public void unsetLast() {
        Point last = sequence.get(sequence.size() - 1);
        board[(int) last.getX()][(int) last.getY()] = 0;
        sequence.remove(sequence.size() - 1);
        filled--;
    }

    public boolean isFull() {
        return (filled == (bSize * bSize));
    }

    public ArrayList<Point> getMoves() {
        ArrayList<Point> moves = new ArrayList<Point>();
        Point last = sequence.get(sequence.size() - 1);
        for (Point point : relativeMoves) {
            int x = (int) (point.getX() + last.getX());
            int y = (int) (point.getY() + last.getY());
            if ( ! (x < 0 || x >= bSize || y < 0 || y >= bSize)) {
                if (board[x][y] == 0) {
                    moves.add(new Point(x, y));
                }
            }
        }
        return moves;
    }

    public boolean knightTour(int x, int y) {
        set(x, y);
        if (isFull()) {
            return true;
        }
/* Trace 
        System.out.printf("Filled: %d\n", filled);
        for (Point point : sequence) {
            System.out.println(point.toString());
        }
*/
        ArrayList<Point> moves = getMoves();
        for (Point point : moves) {
            if (knightTour((int)point.getX(), (int)point.getY())) {
                return true;
            }
        }
        if (filled > maxFilled) {
            maxFilled = filled;
            maxBoard = board.clone();
/* Trace 
            for (int i = 2; i >= 0; i--) {
                for (int j = 0; j < 3; j++) {
                    System.out.printf("%02d ", maxBoard[i][j]);
                }
                System.out.println();
            }
*/
        }
        unsetLast();
        return false;
    }

}
