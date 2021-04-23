package DFSnBFS;
import java.util.*;

public class AllPathsFromSourceToTarget_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph, 0, output, temp);
        return output;
    }

    private void dfs(int[][] graph, int curr, List<List<Integer>> output, List<Integer> temp){
        if(curr == graph.length - 1)
            output.add(new ArrayList<>(temp));
        else{
            for(int next : graph[curr]){
                temp.add(next);
                dfs(graph, next, output, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
