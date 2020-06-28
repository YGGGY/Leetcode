package DFSnBFS;

public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0)    return 0;
        int col = grid[0].length;

        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int row, int col){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j] == '0')//base case
            return;
        grid[i][j] = '0';
        dfs(grid, i+1, j, row, col);
        dfs(grid, i-1, j, row, col);
        dfs(grid, i, j+1, row, col);
        dfs(grid, i, j-1, row, col);
    }

    //Time: O(N) where N = row * col
    //Space: worst case O(N)

    //遍历grid[][]，遇到1之后进行DFS，把这个过程中遇到的1全部变成0
    //每次触发一次DFS，次数+1，最后的总次数就是小岛数量
}
