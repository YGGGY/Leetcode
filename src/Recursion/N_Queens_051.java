package Recursion;
import java.util.*;

public class N_Queens_051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();

        recursion(output, 0, new int[n], n);
        return output;
    }

    private void recursion(List<List<String>> output, int row, int[] queens, int n){
        if(row == n){ //每行都遍历完了 row为0~n-1
            List<String> temp = new ArrayList<>();  //一种答案
            for(int i = 0; i < n; i++){
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(j == queens[i])    //queens[i] 表示第i行的queens在第几列
                        s.append("Q"); //也可以直接String s = "", 每次s = s + "Q"
                    else
                        s.append(".");
                }
                String line = s.toString();
                temp.add(line);
            }
            output.add(temp);
        }
        else{
            for(int col = 0; col < n; col++){
                queens[row] = col;
                if(isValid(row, queens))
                    recursion(output, row+1, queens, n);
            }
        }

    }

    //检查在(row, queens[row])这里放queen是否可以
    private boolean isValid(int row, int[] queens){
        for(int i = 0; i < row; i++){
            //因为recursion里的for循环和backtrack，同一行里只会有一个queen，只用检查正上方和45度方向
            //其他行在这一列有queen       || 两个45度斜方向有queen
            if(queens[i] == queens[row] || Math.abs(queens[row] - queens[i]) == row - i)
                return false;
        }
        return true;
    }
}

//一维数组的下标表示在哪行row，数组的值表示该行的皇后在哪一列col
//而且因为是一维数组，所以回溯的时候不需要进行remove，因为回溯正好回到上一行，此时只需要继续找下一个合适的col作为新的queens[i]的值

//如果只要1个解（做出一个解就立刻返回这个解）的话，将recursion函数的返回值设为boolean
//然后在recursion过程中 if(recursion()) return true; 后输出这个解