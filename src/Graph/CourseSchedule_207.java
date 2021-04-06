package Graph;
import java.util.*;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int[] pre : prerequisites){
            indegree[pre[0]] ++;
            //map.put(pre[1], map.getOrDefault(pre[1], new ArrayList<Integer>()).add(pre[0]));
            List<Integer> endList = map.getOrDefault(pre[1], new ArrayList<>());
            endList.add(pre[0]);
            map.put(pre[1], endList);
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int start = queue.poll();
            count ++;
            if(!map.containsKey(start))  continue;
            List<Integer> ends = map.get(start);
            for(int end : ends){
                indegree[end] --;
                if(indegree[end] == 0)
                    queue.offer(end);
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }
}
