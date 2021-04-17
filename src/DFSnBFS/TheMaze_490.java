package DFSnBFS;
import java.util.*;

public class TheMaze_490 {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start == destination)
            return true;
        return dfs(start[0], start[1], maze, destination, new boolean[maze.length][maze[0].length]);
    }

    private boolean dfs(int i, int j, int[][] maze, int[] dest, boolean[][] startHere){
        if(startHere[i][j] == true)
            return false;
        if(i == dest[0] && j == dest[1])
            return true;

        startHere[i][j] = true;

        for(int[] direct : directions){
            int row = i;
            int col = j;
            while(isValid(maze, row + direct[0], col + direct[1])){
                row = row + direct[0];
                col = col + direct[1];
            }
            if(dfs(row, col, maze, dest, startHere)){
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int i, int j) {
        if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] != 1)
            return true;
        else
            return false;
    }

}
