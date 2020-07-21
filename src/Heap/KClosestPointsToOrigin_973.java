package Heap;
import java.util.*;

public class KClosestPointsToOrigin_973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]);
        for(int [] point : points){
            queue.add(point);
            if(queue.size() > K)
                queue.poll();
        }

        int[][] result = new int[K][2];
        while(K > 0){
            result[K-1] = queue.poll();
            K--;
        }
        return result;
    }
    //Time:o(nlogK)
    //Space:O(K)
}
//用最大堆保存，以每个点到（0，0）的距离排降序
//heap大于k之后删去头结点（heap里最大的数）
//
// 判断用min还是max heap时，只要想想poll的时候是要删掉大的还是小的，删大的用max，删小的用min