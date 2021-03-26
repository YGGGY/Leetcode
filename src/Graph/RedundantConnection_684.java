package Graph;

public class RedundantConnection_684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1); //n edges <-> n+1 nodes

        for(int i = 0; i < n; i++){
            if(!uf.union(edges[i][0], edges[i][1]))
                return edges[i];
        }
        return null;
    }
}

//题意是要去掉 使无向图成环 的边
//即，这条边的两个点都在同一个cluster里，找到这个边去掉
//等于 判断新加的边是否会构成cycle 这个过程
//union过程中，新加的edge的两个vertex都已经存在于cluster里，说明加上这个edge会成环
//px == py，说明x和y是同一个root，说明x和y在同一个cluster，即x和y都已经被加到cluster里了
//Time: O(n^2)
//Space: O(n)


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
        while(parents[x] != x){
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