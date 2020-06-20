package Recursion;

public class WordSearch_079 {
    public boolean exist(char[][] board, String word) {
        if(board == null)   return false;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(recursion(board, word, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean recursion(char[][] board, String remain, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != remain.charAt(0))
            return false;
        else if(remain.length() == 1)
            return true;
        else{
            char temp = board[i][j];
            board[i][j] = '-';
            boolean result = recursion(board, remain.substring(1), i+1, j) ||
                    recursion(board, remain.substring(1), i-1, j) ||
                    recursion(board, remain.substring(1), i, j+1) ||
                    recursion(board, remain.substring(1), i, j-1);
            board[i][j] = temp;
            return result;
        }
    }


}

//从每个格子出发，找有没有路径时能走出这个单词的