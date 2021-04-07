package Graph;
import java.util.*;

public class AccountsMerge_721 {
    //Union-find 做法
    //每个email的id为所在行的index（毕竟同一行说明属于同一个人，用同一个id就好），用map来存email和id的对应关系，一共会有n个点
    //遍历过程中，如果该行有email是已经有id的，说明可以union，就把这个id和该行的id union一下，该行其他的email的id依然为这行的index
    //最后uf的connected component数量为用户数量，把每个component输出，记得email排序+加上用户名在最前面
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); //email -- id

        int n = accounts.size();
        UnionFind uf = new UnionFind(n);  //建立graph，把email和id对应起来，存在有id的email时将2个id进行union
        for(int i = 0 ; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(map.containsKey(email))
                    uf.union(i, map.get(email));
                else
                    map.put(email, i);//没有id的email，给对应上id
            }
        }

        HashMap<Integer, HashSet<String>> indexMap = new HashMap<>(); //id - set of email， 用set来让email不重复
        for(String email : map.keySet()){ //遍历所有的email，取他们的id，用id找root，把email加到root对应的set里
            int i = map.get(email);
            int id = uf.find(i);
            HashSet<String> line = indexMap.getOrDefault(id, new HashSet<>());
            line.add(email);
            indexMap.put(id, line);
        }

        //用id-set of emails, 拼出output:同一个set里的email放一个list，开头加上用户名，加入output
        for(Map.Entry<Integer, HashSet<String>> entry : indexMap.entrySet()){
            int tempId = entry.getKey();
            HashSet<String> emailSet = entry.getValue();
            String name  = accounts.get(tempId).get(0);
            List<String> tempLine = new ArrayList<>();

            for(String tempEmail : emailSet){
                tempLine.add(tempEmail);
            }

            Collections.sort(tempLine);
            tempLine.add(0, name);
            output.add(tempLine);
        }

        return output;

    }




    //--------------------------------------------------------------
    //DFS
    //把每一行[name1, email1,email2, email3]的边用map存成邻接表：email1-email2, email2-email3
    //另外用个map来存email-name的映射，用<set> visited来标记email有没有被检索过
    //对一个email1，找它的相连的点email2，加入list和visitied,再递归找email2的连接点
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> name = new HashMap<>();        //<email, username>
        // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);

                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        // DFS search the graph;
        for (String email : name.keySet()) {
            List<String> list = new LinkedList<>();
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }

        return res;
    }

    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
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
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
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