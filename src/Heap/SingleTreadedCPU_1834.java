package Heap;
import java.util.*;

public class SingleTreadedCPU_1834 {
    public int[] getOrder(int[][] tasks) {
        int curr = 0;
        int n = tasks.length;
        int[] ans = new int[n];
        int ansIndex = 0;

        Task[] newTasks= new Task[n];
        for(int i = 0; i < n; i++){
            Task t = new Task(tasks[i][0], tasks[i][1], i);
            newTasks[i] = t;
        }

        Arrays.sort(newTasks, (o1, o2) -> o1.startTime - o2.startTime);
        int time = newTasks[0].startTime;

        PriorityQueue<Task> heap = new PriorityQueue<>(new Comparator<Task>(){
            @Override
            public int compare(Task o1, Task o2){
                if(o1.processTime < o2.processTime)
                    return -1;
                else if(o1.processTime == o2.processTime)
                    return o1.index - o2.index;
                else
                    return 1;
            }
        });

        while(ansIndex < n){
            while(curr < n && newTasks[curr].startTime <= time){
                heap.offer(newTasks[curr]);
                curr ++;
            }
            if(heap.isEmpty()){
                time = newTasks[curr].startTime;
                continue;
            }
            Task processed = heap.poll();
            ans[ansIndex] = processed.index;
            time = time + processed.processTime;
            ansIndex ++;
        }

        return ans;
    }

    class Task{
        int startTime;
        int processTime;
        int index;
        public Task(int startTime, int processTime, int index){
            this.startTime = startTime;
            this.processTime = processTime;
            this.index = index;
        }
    }
}
