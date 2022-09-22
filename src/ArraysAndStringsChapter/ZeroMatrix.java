package ArraysAndStringsChapter;

import java.util.Arrays;

public class ZeroMatrix {

    public static int [][] zeroMatrix(int [][] matrix){
        int [][] res = new int[matrix.length][matrix[0].length];

        for (int[] re : res) {
            Arrays.fill(re,-1);
        }

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if(res[x][y] == -1) res[x][y] = matrix[x][y];
                if(matrix[x][y] == 0){
                    for(int xIndex = 0;xIndex< matrix.length; xIndex++){
                        res[xIndex][y] = 0;
                    }
                    for(int yIndex = 0;yIndex< matrix[x].length; yIndex++){
                        res[x][yIndex] = 0;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [][] dataZero = new int [][]{
                {0,2,3,4},
                {5,6,7,0},
                {9,10,11,12},
                {13,14,15,16}};
        System.out.println(Arrays.deepToString(zeroMatrix(dataZero)));
    }

}
