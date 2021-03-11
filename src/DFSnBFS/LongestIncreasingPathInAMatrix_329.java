package DFSnBFS;

public class LongestIncreasingPathInAMatrix_329 {
    private int[][] directions = {{0,1}, {0,-1}, {1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] record = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dfs(i, j, n, m, matrix, record));//dfs(i,):以[i][j]为起始点的最长path长
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int n, int m, int[][] matrix, int[][] record){
        if(record[i][j] != 0)
            return record[i][j];

        record[i][j] = 1;
        for(int[] direction : directions){
            int x = i + direction[0];
            int y = j + direction[1];
            //找到四周的格子里，比[i][j]大的数，然后以[i][j]为起始点+这个数为起始点的path长就是新的path长，取最长的path
            if(x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j])
                record[i][j] = Math.max(record[i][j], dfs(x,y,n,m,matrix,record) + 1);
        }
        return record[i][j];
    }
}

//因为每个格子的record[i][j]最多算一次 所以Time: O(mn), Space:O(mn)

//如果不用memorization的话 复杂度是O(2^(m+n))
//时间复杂度是每个可能的path的长度加在一起
//最差的情况是左上角小数，右下角大数。计算一下总共有多少个path，每个多长
//--> 每个格子2个方向（有向图四个方向实际上平均每个格子2个方向，可以认为每次只能往右或往左，
//--> 横的m和竖的n共有n+m次选择走上还是走下，所以是2为底的n+m次方
