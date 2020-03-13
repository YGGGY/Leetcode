package Recursion;

public class WordSearch_079 {
    //x is the index of current char
    //(i, j) is the position on the board
    public boolean backtrack(char[][] board, String word, int x, int i, int j){
        int row_len = board.length;
        int column_len = board[0].length;

        if(x == word.length())//the word has been found
            return true;

        if(i < 0 || j < 0 || i >= row_len || j >= column_len || board[i][j] != word.charAt(x))
            return false;//this route end up with wrong
        else{//continue checking
            char temp = board[i][j];
            board[i][j] = '-';//turn current char into -, so that we will not go back to here
            //recursion by 4 directions
            boolean result = backtrack(board, word, x+1, i-1, j) ||
                    backtrack(board, word, x+1, i+1,j)||
                    backtrack(board, word, x+1, i, j-1)||
                    backtrack(board, word, x+1, i, j+1);
            board[i][j] = temp;//when traced back, turn current grid back to previous char, in case we need it in other route
            return result;
        }
    }

    public boolean exist(char[][] board, String word) {
        int row_len = board.length;
        int column_len = board[0].length;
        if(board == null)   return false;

        for(int i = 0; i < row_len; i++){
            for(int j = 0; j < column_len; j++){
                if(backtrack(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
}
