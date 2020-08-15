package Graph;
import java.util.*;

public class FriendCycles_547 {
    //------------------------------------
    //dfs
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if(n == 0)  return 0;

        int[] visited = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(visited[i] == 1)//走过的人就别走了
                continue;
            dfs(i, M, visited);//一次走到底的dfs是一个朋友圈
            count ++;
        }

        return count;
    }

    private void dfs(int i, int[][] M, int[] visited){
        if(visited[i] == 1) return;

        visited[i] = 1;//设为查过

        for(int j = 0; j < M.length; j++){
            if(visited[j] == 0 && M[i][j] == 1)//要没走过 && 是朋友 才继续走
                dfs(j, M, visited);
        }
    }
    //本质是找strong connected component
    //dfs遍历，用visited标记有没有找过这个人，直到找不到新的朋友了就是一个强连通

    //--------------------------------------
    //Union Find
    public int findCircleNum2(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(M[i][j] == 1)
                    uf.union(i, j);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            int root = uf.find(i);
            set.add(root);
        }

        return set.size();
    }
}

class UnionFind{
    private int[] parents;
    private int[] rank;

    public UnionFind(int n){//初始化
        parents = new int[n+1];//每个节点的父节点，初始为该节点自己（表示每个点为独立的点）
        rank = new int[n+1];//初始时 每个节点一个cluster，rank为1
        for(int i = 0; i < n+1; i++){
            parents[i] = i;
            rank[i] = 1;
        }
    }

    //find(): 找x的根节点
    public int find(int x){
        while(parents[x] != x){
            parents[x] = parents[parents[x]]; //沿着父节点往上找根节点
            x = parents[x];
        }
        return x;//x的根节点
    }

    //union(x, y): 把x在的cluster和y在的cluster并起来
    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py)    return false;  //x和y在同一个cluster里

        if(rank[px] > rank[py])
            parents[py] = px;          //把y在的cluster并到x在的cluster上--y的根节点的父节点 设为 x的根节点
            //这个过程不会改变rank
        else if(rank[px] < rank[py])
            parents[px] = py;
        else{   //rank[px] == rank[py]
            parents[py] = px;
            rank[px] ++;                //两个相同rank的并在一起，会导致rank+1
        }

        return true;
    }
}
