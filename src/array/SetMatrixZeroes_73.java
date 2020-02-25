package array;

public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int row = matrix.length;//行数
        int column = matrix[0].length;//列数

        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0)//第一列存在0
                isCol = true;
            //每行从第二列开始遍历行
            for(int j = 1; j < column; j++){
                if(matrix[i][j] == 0){//使0在的行&列的第一个数变为0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //从第二行第二列开始遍历，第一行/第一列为0的点设为0
        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        //如果第一个点为0，第一行的点设为0
        if(matrix[0][0] == 0){
            for(int j = 0; j < column; j++){
                matrix[0][j] = 0;
            }
        }
        //第一列的点设为0
        if(isCol){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }


    }
}
