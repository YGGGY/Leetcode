package array;

public class SearchA2DMatrix_74 {
    //start from the rightmost upper point
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_num = matrix.length;
        if(row_num == 0) return false;
        int column_num = matrix[0].length;
        if(column_num == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while(row < row_num && col >= 0){
            if(target > matrix[row][col])
                row++;
            else if(target < matrix[row][col])
                col--;
            else
                return true;
        }
        return false;
    }

    //Turn into 1D array and use binary search

}
