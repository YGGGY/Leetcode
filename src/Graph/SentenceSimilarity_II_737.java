package Graph;
import java.util.*;

public class SentenceSimilarity_II_737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length)  return false;
        int n = pairs.size() * 2;  //注意这里用pairs而不是words1
        UnionFind uf = new UnionFind(n);

        //用Hashmap把单词的string用int表示 union pairs里的单词
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for(List<String> pair : pairs){
            for(String p : pair){
                if(!map.containsKey(p))
                    map.put(p, index++);
            }
            uf.union(map.get(pair.get(0)), map.get(pair.get(1)));
        }


        for(int i = 0; i < words1.length; i++){
            String x = words1[i];
            String y = words2[i];
            if(x.equals(y)) continue;
            if(!map.containsKey(x) || !map.containsKey(y) || uf.find(map.get(x)) != uf.find(map.get(y)))
                return false;
        }
        return true;
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
        else if(rank[px] <rank[py])
            parents[px] = py;
        else{
            parents[py] = px;
            rank[px] ++;
        }
        return true;
    }
}