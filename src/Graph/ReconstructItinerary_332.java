package Graph;
import java.util.*;

public class ReconstructItinerary_332 {
    //------------------------------------
    //Greedy+DFS
    public List<String> findItinerary2(List<List<String>> tickets) {
        if(tickets == null || tickets.isEmpty())    return null;

        //把origin和对应的dest放入hashmap中
        HashMap<String, List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if(!map.containsKey(origin)){
                map.put(origin, new LinkedList<String>());
            }
            map.get(origin).add(dest);
        }

        //排序每个origin对应的dest
        for(List<String> list: map.values()){
            Collections.sort(list);
        }

        //走dfs
        LinkedList<String> result = new LinkedList<String>();
        result.add("JFK");
        if(dfs("JFK", result, map, tickets.size()+1))//E条edge遍历完，总共有E+1个点
            return result;
        else
            return null;
    }


    private boolean dfs(String origin, LinkedList<String> result, HashMap<String, List<String>> map, int length){
        if(result.size() == length){
            return true;
        }

        if(!map.containsKey(origin) || map.get(origin) == null)//base case
            return false;

        List<String> dests = map.get(origin);
        for(int i = 0; i < dests.size(); i++){
            String dest = dests.get(i);
            //删掉
            dests.remove(i);
            result.add(dest);
            //dfs
            if(dfs(dest, result, map, length))
                return true;
            //加回去
            result.remove(result.size() -1);
            dests.add(i, dest);
        }
        return false;
    }


    //------------------------------------
    //Eulerian Path
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> result = new LinkedList<String>();//按结果顺序的城市list

        //把出发地和他的sorted的dest（以priority queue形式），作为key-value放入hashmap中
        for(List<String> ticket : tickets){
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if(!map.containsKey(origin)){//这个出发点还没存过，建立对应的queue，并作为Key-value存进HashMap
                PriorityQueue<String> queue = new PriorityQueue<>();
                map.put(origin, queue);
            }
            map.get(origin).add(dest);//获取origin对应的queue，把dest存进queue里
        }
        //从JFK出发开始遍历所有edge
        dfs("JFK", result, map);
        return result;
    }

    private void dfs(String origin, LinkedList<String> result, HashMap<String, PriorityQueue<String>> map){
        PriorityQueue<String> queue = map.get(origin);//获取origin能去到的dest

        while(queue != null && !queue.isEmpty()){//queue !=null判断：是否存在这样的key-value
                                                //要注意queue==null和queue.isEmpty()是不一样的
            dfs(queue.poll(), result, map);//先取一个最小的，继续往下走
        }
        //queue为空，所有edge都遍历完了
        result.addFirst(origin);//从后往前加，每次return前，加在最前面
    }




}

//看笔记