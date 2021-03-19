package DFSnBFS;
import java.util.*;

public class KeysAndRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        visited[0] = true;

        while(!stack.isEmpty()){
            int curr = stack.pop();
            for(int temp : rooms.get(curr)){
                if(!visited[temp]){ //没去过这个room
                    visited[temp] = true;
                    stack.push(temp);
                }
            }
        }

        for(boolean temp : visited){
            if(temp == false)
                return false;
        }
        return true;
    }

}

//Time: O(V+E) V is # of rooms, E is # of all keys
//Space: O(V) for stack and visited[] array
