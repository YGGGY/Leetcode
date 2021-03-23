package DFSnBFS;
import java.util.*;

public class NumberOfIslands_200 {
    //-----------------------dfs--------------------------
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

    //Time: O(mn)
    //Space: worst case O(mn)
    //遍历grid[][]，遇到1之后进行DFS，把这个过程中遇到的1全部变成0
    //每次触发一次DFS，次数+1，最后的总次数就是小岛数量



    //-----------------------bfs------------------------
    //把1的点改为0压入queue，然后每次从queue取一个，找上下左右为1的点改为0压入queue
    public int numIslands2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        int row = curr[0];
                        int col = curr[1];
                        if(row + 1 < n && grid[row+1][col] == '1'){
                            grid[row+1][col] = '0';
                            queue.add(new int[]{row+1, col});
                        }
                        if(row - 1 >= 0 && grid[row-1][col] == '1'){
                            grid[row-1][col] = '0';
                            queue.add(new int[]{row-1, col});
                        }
                        if(col + 1 < m && grid[row][col+1] == '1'){
                            grid[row][col+1] = '0';
                            queue.add(new int[]{row, col+1});
                        }
                        if(col - 1 >= 0 && grid[row][col-1] == '1'){
                            grid[row][col-1] = '0';
                            queue.add(new int[]{row, col-1});
                        }
                    }
                }
            }
        }
        return count;
    }
    //Time: O(mn)
    //Space: O(min(m, n))



    //-------------------union find-----------------------


}
