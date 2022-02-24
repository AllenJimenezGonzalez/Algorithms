package ArraysAndStringsChapter;

import java.util.Arrays;

public class RotateMatrix {

    public int [][] rotateMatrix(int [][] normalMatrix){
        int size = normalMatrix.length;
        int [][] result = new int [size][size];
        int counter=size-1;
        for (int index1 = 0; index1 < size; index1++ ){
            for (int index2 = 0; index2 < size; index2++ ){
                result[index2][counter] = normalMatrix[index1][index2];
            }
            counter--;
        }
        return result;
    }

    public void printMatrix (int [][] matrix){
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
