package DFSnBFS;
import java.util.*;

public class PacificAtlanticWaterFlow_417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visitedP = new boolean[row][col];
        boolean[][] visitedA = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<int[]> queueP = new LinkedList<>();
        Queue<int[]> queueA = new LinkedList<>();
        for(int i = 0; i < row; i++){
            queueP.offer(new int[]{i, 0});
            queueA.offer(new int[]{i, col-1});
        }
        for(int j = 0; j < col; j++){
            queueP.offer(new int[]{0, j});
            queueA.offer(new int[]{row-1, j});
        }
        bfs(matrix, row, col, queueP, pacific, visitedP);
        bfs(matrix, row, col, queueA, atlantic, visitedA);

        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = Arrays.asList(i, j);
                    output.add(temp);
                }
            }
        }
        return output;
    }

    private void bfs(int[][] matrix, int row, int col, Queue<int[]> queue, boolean[][] reachable, boolean[][] visited){
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            reachable[i][j] = true;
            visited[i][j] = true;
            if(i+1 < row && !visited[i+1][j] && matrix[i+1][j] >= matrix[i][j])
                queue.offer(new int[]{i+1, j});
            if(i-1 >= 0 && !visited[i-1][j] && matrix[i-1][j] >= matrix[i][j])
                queue.offer(new int[]{i-1, j});
            if(j+1 < col && !visited[i][j+1] && matrix[i][j+1] >= matrix[i][j])
                queue.offer(new int[]{i, j+1});
            if(j-1 >= 0 && !visited[i][j-1] && matrix[i][j-1] >= matrix[i][j])
                queue.offer(new int[]{i, j-1});
        }
    }
}

//Time: O(mn)
//Space: O(mn)

//用dfs也可以做，本质都是从两边出发找能触及的点，再求共同触及点。bfs是用queue找，dfs用递归找