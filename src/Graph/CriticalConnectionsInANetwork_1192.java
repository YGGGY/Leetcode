package Graph;
import java.util.*;

public class CriticalConnectionsInANetwork_1192 {
    int index = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] idx = new int[n];
        int[] low = new int[n];

        List<List<Integer>> output = new ArrayList<>();
        boolean[] visited = new boolean[n];

        //build graph
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < connections.size(); i++){
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i])
                dfs(i, i, low, idx, graph, visited, output);
        }
        return output;
    }

    private void dfs(int x, int parent, int[] low, int[] idx, List<Integer>[] graph, boolean[] visited, List<List<Integer>> output){
        visited[x] = true;
        index ++;
        low[x] = idx[x] = index;
        for(int y : graph[x]){
            if(y == parent)  continue;
            if(!visited[y]){
                dfs(y, x, low, idx, graph, visited, output);
                low[x] = Math.min(low[x], low[y]);
                if(low[y] > idx[x])
                    output.add(Arrays.asList(x, y));
            }
            else{ //遇到一个visit过的点，（这个index可能比较小，能用来更新low[x]）（是搜索树外的边）
                low[x] = Math.min(low[x], idx[y]);
            }
        }
    }
}
