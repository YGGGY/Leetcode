package HashMap;
import java.util.*;

public class FindingTheUsersActiveMinutes_1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] log : logs){
            int id = log[0];
            int time = log[1];
            HashSet<Integer> set = map.getOrDefault(id, new HashSet<Integer>());
            set.add(time);
            map.put(id, set);
        }

        int[] times = new int[k];
        for(Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()){
            int size = entry.getValue().size();
            times[size-1] ++;
        }

        return times;

    }
}
