package Recursion;

public class SodokuSolver_037 {
    public void solveSudoku(char[][] board) {
        if(board.length == 0)   return;
        recursion(board, 0);
    }

    private boolean recursion(char[][] board, int row){ //只要一个解的时候返回值设为boolean
        for(int i = row; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.')
                    continue;
                else{
                    for(char num = '1'; num <= '9'; num++){
                        if(isValid(i, j, num, board)){
                            board[i][j] = num;
                            if(recursion(board, i))     //只要一个解
                                return true;
                            board[i][j] = '.';          //backtrack
                        }
                    }
                }
                return false;  //决策树的这一层都走了一遍没有return过true，说明这一行没有正确解
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char num, char[][] board){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num)    return false; //检查同行
            if(board[i][col] == num)    return false; //检查同列
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == num)  return false; //检查9宫格
            //3*(row/3)和3*(col/3)决定了在哪个九宫格，在通过i来决定取到哪个格子
            //i/3和i%3都是取0-2的数，但是不能都用i/3或者i%3，这样会导致只能取到九宫格里的3个格子(0,0)(1,1)(2,2)
        }
        return true;
    }
}
