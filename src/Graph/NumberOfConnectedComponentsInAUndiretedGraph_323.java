package Graph;
import java.util.*;

public class NumberOfConnectedComponentsInAUndiretedGraph_323 {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            int temp = uf.find(i);
            set.add(temp);
        }
        return set.size();
    }
}

class UnionFind{
    private int[] parents;
    private int[] rank;

    public UnionFind(int n){
        parents = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        while(x != parents[x]){
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py)    return false;

        if(rank[px] > rank[py])
            parents[py] = px;
        else if(rank[px] < rank[py])
            parents[px] = py;
        else{
            parents[py] = px;
            rank[px] ++;
        }
        return true;
    }
}