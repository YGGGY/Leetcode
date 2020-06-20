package Recursion;

public class SurroundedRegions_130 {

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)   return;
        if(board.length < 2 || board[0].length < 2) return;

        int m = board.length;
        int n = board[0].length;

        //把边界上所有的O+和它相连的O 变成E
        //从第一列和最后一列上的O出发，把遇到的O变成E
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O')    //找第一列上的O
                DFS(board, i, 0);     //并从这个O出发找相连的O
            if(board[i][n-1] == 'O')  //找最后一列上的O
                DFS(board, i, n-1);   //并从这个O出发找相连的O
        }
        //从第一行和最后一行上的O开始，把遇到的O变成E
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O')      //找第一行上的O
                DFS(board, 0, j);       //并从这个O出发找相连的O
            if(board[m-1][j] == 'O')    //找最后一行上的O
                DFS(board, m-1,j);      //并从这个O出发找相连的O
        }

        //把剩下的O变成X，E变回O
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }
    }

    //这个递归函数的作用：通过递归走左右上下，找所有相连的O，并将其变成E
    private void DFS(char[][] board, int i, int j){
        //base case
        if(i<0 || i > board.length -1 || j<0 || j > board[0].length-1)
            return;
        //把O变成E
        if(board[i][j] == 'O')
            board[i][j] = 'E';

        if(i>1 && board[i-1][j] == 'O')
            DFS(board, i-1, j);//往左
        if(i < board.length -2 && board[i+1][j] == 'O')//因为不需要检查到最后一列，所以是<length-2，即i+1检查到倒数第二列i=length-1
            DFS(board, i+1, j);//往右
        if(j>1 && board[i][j-1] == 'O')
            DFS(board, i, j-1);//往上
        if(j < board[i].length - 2 && board[i][j+1] == 'O')//同上，不用检查到最后一行
            DFS(board, i, j+1);//往下
    }

}