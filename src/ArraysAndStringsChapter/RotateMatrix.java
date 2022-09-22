package ArraysAndStringsChapter;

import java.util.Arrays;

public class RotateMatrix {

    public static int [][] rotateMatrix(int [][] matrix){
        int [][] response = new int[matrix.length][matrix.length];

        int matrixIndex = matrix.length-1;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < response[y].length; x++) {
                response[x][matrixIndex-y] = matrix[y][x];
            }
        }
        return response;
    }

    public void printMatrix (int [][] matrix){
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void main(String[] args) {
        int [][] data = new int [][]{
                {1,2,3},
                {5,6,7},
                {9,10,11}};
        System.out.println(Arrays.deepToString(rotateMatrix(data)));
    }

}
