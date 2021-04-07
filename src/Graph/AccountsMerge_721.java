package Graph;
import java.util.*;

public class AccountsMerge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //每个email的id为所在行的index（毕竟同一行说明属于同一个人，用同一个id就好），用map来存email和id的对应关系，一共会有n个点
        //遍历过程中，如果该行有email是已经有id的，说明可以union，就把这个id和该行的id union一下，该行其他的email的id依然为这行的index
        //最后uf的connected component数量为用户数量，把每个component输出，记得email排序+加上用户名在最前面
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