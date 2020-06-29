package Graph;
import java.util.*;

public class ReconstructItinerary_332 {
    //------------------------------------
    //Greedy+DFS









    //------------------------------------
    //Eulerian Path
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> result = new LinkedList<String>();

        //把目的地和他的sorted的dest（以priority queue形式），作为key-value放入hashmap中
        for(List<String> ticket : tickets){
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if(!map.containsKey(origin)){
                PriorityQueue<String> queue = new PriorityQueue<>();
                map.put(origin, queue);
            }
            map.get(origin).add(dest);
        }

        dfs("JFK", result, map);
        return result;
    }

    private void dfs(String s, LinkedList<String> result, HashMap<String, PriorityQueue<String>> map){
        PriorityQueue<String> queue = map.get(s);

        while(queue != null && !queue.isEmpty()){
            dfs(queue.poll(), result, map);
        }

        result.addFirst(s);
    }




}

//看笔记