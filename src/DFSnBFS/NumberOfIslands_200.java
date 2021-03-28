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
    //别的unionfind都是邻接表/邻接矩阵，矩阵是n*n的，一共n个点，0~n-1正好代表每个点
    //但这题有n*m个点，所以每个点[i,j]用i*col+j来表示
    public int numIslands3(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    for(int[] direction : directions){
                        int row = i + direction[0];
                        int col = j + direction[1];
                        if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1'){
                            int id1 = i * m + j;
                            int id2 = row * m + col;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.getCount();
    }
    //Time: O(mn)
    //Space: O(mn)
}

class UnionFind{
    private int[] parents;
    //private int[] rank;    //这次其实不用管rank，反正联通的一定会并一起就行了
    private int count; //用count数来记录cluster数，每加一个node时+1，union一次时-1

    public UnionFind(char[][] grid){ //传入matrix，把所有为1的格子初始化为节点，节点id为i * col + j
        int n = grid.length;
        int m = grid[0].length;
        parents = new int[n*m];
        //rank = new int[n*m];
        count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    int id = i * m + j;
                    parents[id] = id;
                    count ++;
                }
            }
        }
    }

    public int find(int x){
        if(parents[x] != x)
            parents[x] = find(parents[x]);
        return parents[x];
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py)    return;

        if(px != py)
            parents[py] = px;
        count --;
    }

    public int getCount(){
        return count;
    }
}