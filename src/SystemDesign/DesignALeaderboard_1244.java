package SystemDesign;
import java.util.*;

public class DesignALeaderboard_1244 {
    private HashMap<Integer, Integer> map;
    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        int currentScore = map.getOrDefault(playerId, 0);
        map.put(playerId, score+currentScore);
    }

    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> (a.getValue() - b.getValue()));//min heap
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(entry);
            if(heap.size() > K)
                heap.poll();
        }

        int sum = 0;
        for(int i = 0; i < K; i++){
            Map.Entry<Integer,Integer> entry = heap.poll();
            sum += entry.getValue();
        }
        return sum;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}
