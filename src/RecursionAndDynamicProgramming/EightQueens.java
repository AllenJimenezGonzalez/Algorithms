package RecursionAndDynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;

public class EightQueens {

    public static boolean validateQueenDiagonals(int[] queen, int x, int y) {
        int auxX = x;
        int auxY = y;

        int queenXPosition = queen[0];
        int queenYPosition = queen[1];

        while (auxX >= 0 && auxY >= 0) {
            if (queenXPosition == auxX && queenYPosition == auxY) return false;
            auxX--;
            auxY--;
        }

        auxX = x;
        auxY = y;

        while (auxX < 8 && auxY < 8) {
            if (queenXPosition == auxX && queenYPosition == auxY) return false;
            auxX++;
            auxY++;
        }

        auxX = x;
        auxY = y;

        while (auxX < 8 && auxY >= 0) {
            if (queenXPosition == auxX && queenYPosition == auxY) return false;
            auxX++;
            auxY--;
        }

        auxX = x;
        auxY = y;

        while (auxX >= 0 && auxY < 8) {
            if (queenXPosition == auxX && queenYPosition == auxY) return false;
            auxX--;
            auxY++;
        }

        return true;

    }

    public static boolean validateQueenPosition(LinkedList<int[]> queens, int x, int y) {
        for (int[] queen : queens) {
            int queenXPosition = queen[0];
            int queenYPosition = queen[1];
            if (queenXPosition == x || queenYPosition == y) return false;
            if (!validateQueenDiagonals(queen, x, y)) return false;
        }
        return true;
    }

    public static void printBoard(LinkedList<int[]> queens) {

        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(board[i], "-");
        }

        for (int[] queen : queens) {
            int queenXPosition = queen[0];
            int queenYPosition = queen[1];
            board[queenXPosition][queenYPosition] = "♕";
        }

        Arrays.stream(board).forEach(boardRow -> System.out.println(Arrays.toString(boardRow)));
        System.out.println("");

    }

    public static void calculateQueensPositions(LinkedList<int[]> queens, boolean[][] visitedFlags, int leftQueens, int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) return;

        if (visitedFlags[x][y]) return;
        visitedFlags[x][y] = true;

        if (leftQueens == 0) {
            printBoard(queens);
            System.out.println("\n\n\n");
            return;
        }


        if (validateQueenPosition(queens, x, y)) {
            queens.add(new int[]{x, y});
            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x + 1, y + 2);
            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x + 1, y - 2);
            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x - 1, y + 2);
            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x - 1, y - 2);


            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x + 2, y + 1);
            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x + 2, y - 1);
            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x - 2, y + 1);
            calculateQueensPositions(queens, visitedFlags, leftQueens - 1, x - 2, y - 1);


            queens.pop();
        }
        calculateQueensPositions(queens, visitedFlags, leftQueens, x + 1, y + 2);
        calculateQueensPositions(queens, visitedFlags, leftQueens, x + 1, y - 2);
        calculateQueensPositions(queens, visitedFlags, leftQueens, x - 1, y + 2);
        calculateQueensPositions(queens, visitedFlags, leftQueens, x - 1, y - 2);

        calculateQueensPositions(queens, visitedFlags, leftQueens, x + 2, y + 1);
        calculateQueensPositions(queens, visitedFlags, leftQueens, x + 2, y - 1);
        calculateQueensPositions(queens, visitedFlags, leftQueens, x - 2, y + 1);
        calculateQueensPositions(queens, visitedFlags, leftQueens, x - 2, y - 1);
    }

    public static void cPositions(LinkedList<int[]> queens, int leftQueens, int row) {

        if (leftQueens == 0) {
            printBoard(queens);
            return;
        }

        if (row > 7) {
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (validateQueenPosition(queens, row, column)) {
                queens.add(new int[]{row, column});
                cPositions(queens, leftQueens - 1, row + 1);
                queens.removeLast();
            }
        }

    }

    public static void cPositions() {
        cPositions(new LinkedList<>(), 8, 0);
    }

    public static void calculateQueensPositions() {
        LinkedList<int[]> queens;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                queens = new LinkedList<>();
                queens.add(new int[]{i, j});
                calculateQueensPositions(queens, new boolean[8][8], 8, 0, 0);
            }
        }
    }


    public static void main(String[] args) {
        //calculateQueensPositions();
        cPositions();
    }

}
