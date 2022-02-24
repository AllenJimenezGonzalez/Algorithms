package ArraysAndStringsChapter;

public class ZeroMatrix {

    public int [][] getZeroMatrix(int [][] matrix){
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.printMatrix(matrix);
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {

                if(matrix[i][i1] == 0){

                    int xSize = matrix.length;
                    int ySize = matrix[i].length;
                    
                    for (int ix = 0; ix<xSize;ix++){
                        matrix[ix][i1] = 0;
                    }
                    
                    for (int iy = 0; iy<ySize;iy++){
                        matrix[i][iy] = 0;

                    }
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println("");
        rotateMatrix.printMatrix(matrix);
        return matrix;
    }

}
