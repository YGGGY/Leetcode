package Heap;
import java.util.*;

public class MaximumAveragePassRatio_1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //写一个heap，分子分母都+1后改变最大的排前面
        //把extraStudents一次一个的加入班级，取heap提升的最大的加，加完再把新的class压入heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                double result1 = (double)(o1[0]+1)/(o1[1]+1) - (double)o1[0]/o1[1];
                double result2 = (double)(o2[0]+1)/(o2[1]+1) - (double)o2[0]/o2[1];
                if(result1 > result2)
                    return -1;
                else
                    return 1;
            }
        });

        for(int i = 0; i < classes.length; i++){
            pq.offer(classes[i]);
        }

        for(int i = 0; i < extraStudents; i++){
            int[] current = pq.poll();
            current[0] ++;
            current[1] ++;
            pq.offer(current);
        }

        double ans = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            ans += (double)temp[0]/temp[1];
        }
        ans = ans /classes.length;
        return ans;
    }
}
