package HashMap;
import java.util.*;

public class BrickWall_554 {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        HashMap<Integer, Integer> map = new HashMap<>();//index -> count

        for(List<Integer> row : wall){
            int sum = 0;
            for(int i = 0; i < row.size()-1; i++){
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int max = 0;
        for(int count : map.values()){
            max = Math.max(max, count);
        }
        return n - max;
    }
}
