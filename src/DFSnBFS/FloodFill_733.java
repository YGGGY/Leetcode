package DFSnBFS;

public class FloodFill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        if(row == 0)    return image;
        int col = image[0].length;
        if(sr >= row || sc >= col)
            return image;

        int color = image[sr][sc];
        if(color != newColor)//不加这个判断会导致下面的DFS stack overflow，不知道为什么。。
            dfs(image, sr, sc, row, col, color, newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int row, int col, int color, int newColor){
        if(i < 0 || j < 0 || i>= row || j >= col || image[i][j] != color)
            return;

        image[i][j] = newColor;
        dfs(image, i+1, j, row, col, color, newColor);
        dfs(image, i-1, j, row, col, color, newColor);
        dfs(image, i, j+1, row, col, color, newColor);
        dfs(image, i, j-1, row, col, color, newColor);
    }
}

