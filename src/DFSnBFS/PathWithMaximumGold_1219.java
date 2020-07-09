package DFSnBFS;

public class PathWithMaximumGold_1219 {
    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int temp = dfs(grid, i, j, row, col);
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j>= col || grid[i][j] == 0)
            return 0;

        int gold = grid[i][j];
        grid[i][j] = 0;//mark visited
        int max = 0;
        max = Math.max(max, gold + dfs(grid, i+1, j, row, col));
        max = Math.max(max, gold + dfs(grid, i-1, j, row, col));
        max = Math.max(max, gold + dfs(grid, i, j+1, row, col));
        max = Math.max(max, gold + dfs(grid, i, j-1, row, col));
        grid[i][j] = gold;//记得改回去，不然会影响到以后的遍历
        return max;
    }
}
