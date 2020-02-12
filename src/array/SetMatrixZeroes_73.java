package array;

public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int row = matrix.length;//行数
        int column = matrix[0].length;//列数

        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0)//第一列有数为0
                isCol = true;
            //每一行的第二列开始
            for(int j = 1; j < column; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0; j < column; j++){
                matrix[0][j] = 0;
            }
        }

        if(isCol){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }


    }
}
