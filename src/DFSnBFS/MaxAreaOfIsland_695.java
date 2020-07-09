package DFSnBFS;

public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    int temp = dfs(grid, i, j, row, col);
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int row, int col){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1)
            return 0;

        grid[i][j] = 0;//遍历到的点记得改数，以免重复计算
        return (1+dfs(grid, i+1, j, row, col)+
                dfs(grid, i-1, j, row, col)+
                dfs(grid, i, j+1, row, col)+
                dfs(grid, i, j-1, row, col));
    }
}
