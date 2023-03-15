package RecursionAndDynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class RobotInGrid {

    static class Coordinate {
        public int x;
        public int y;
        public boolean end = false;

        public Coordinate next;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate(int x, int y, boolean end) {
            this.x = x;
            this.y = y;
            this.end = end;
        }

        public boolean isEnd() {
            return end;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static Coordinate findPath(int[][] grid, int x, int y, int maxX, int maxY) {


        if (x < maxX && y < maxY && grid[x][y] == 0) {
            // Mark if is already visited
            grid[x][y] = 5;

            Coordinate moveRight = findPath(grid, x, y + 1, maxX, maxY);
            Coordinate moveDown = findPath(grid, x + 1, y, maxX, maxY);

            if (moveRight != null && moveRight.isEnd()) {
                Coordinate actualCoordinate = new Coordinate(x, y, true);
                actualCoordinate.next = moveRight;
                return actualCoordinate;
            }

            if (moveDown != null && moveDown.isEnd()) {
                Coordinate actualCoordinate = new Coordinate(x, y, true);
                actualCoordinate.next = moveDown;
                return actualCoordinate;
            }

        }

        if (x == maxX - 1 && y == maxY - 1) return new Coordinate(x, y, true);


        return null;
    }

    public static Stack<Coordinate> findPath(int[][] grid) {
        Stack<Coordinate> res = new Stack<>();
        Coordinate root = findPath(grid, 0, 0, grid.length, grid.length);
        while (root != null) {
            res.push(root);
            System.out.println(root);
            root = root.next;
        }

        //String resS = findPath(grid, 0, 0, grid.length, grid.length);
        //System.out.println(resS.length() / 2);
        return res;
    }

    public static int[][] generateRandomGrid(int size) {
        int[][] grid = new int[size][size];

        for (int[] subGrid : grid) {
            Arrays.fill(subGrid, 0);
            int random = (int) Math.floor(Math.random() * (size));
            subGrid[random] = 1;
        }

        grid[0][0] = 0;
        grid[size - 1][size - 1] = 0;

        return grid;
    }

    public static void printGrid(int[][] ogGrid) {
        for (int[] row : ogGrid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[][] ogGrid = generateRandomGrid(6);
        printGrid(ogGrid);
        Stack<Coordinate> res = findPath(ogGrid);
        while (!res.isEmpty()) {
            Coordinate line = res.pop();
            ogGrid[line.x][line.y] = 2;
        }
        System.out.println("");
        printGrid(ogGrid);
    }

}
