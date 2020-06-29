package Graph;
import java.util.*;

public class ReconstructItinerary_332 {
    //------------------------------------
    //Greedy+DFS









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

        while(queue != null && !queue.isEmpty()){//queue !=null判断：从hashmap里取到的queue是否已经是null了，即出发点的所有dest都走过了
                                                //要注意queue==null和queue.isEmpty()是不一样的
            dfs(queue.poll(), result, map);//先取一个最小的，继续往下走
        }
        //queue为空，所有edge都遍历完了
        result.addFirst(origin);//从后往前加，每次return前，加在最前面
    }




}

//看笔记