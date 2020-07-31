package Heap;
import java.util.*;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int n : nums){
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
    //Time:O(nlogk)---heap每次add需要O(logk)， k为heap的size，一共n次
    //Space:O(k)
}
//用min heap保存各个数，heap里超过k个数以后删去头结点（最小的数）
//这样最后剩下的k个数里，头结点就是第k大的