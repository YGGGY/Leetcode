package Heap;
import java.util.*;

public class TopKFrequentElements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        //List<Integer> output = new ArrayList<>();
        if(nums.length == 0)
            return null;

        //add elements and its frequence to hashmap    ---- O(n)
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n))
                map.put(n, map.get(n)+1);
            else
                map.put(n,1);
        }

        //add elements to min heap, sorted by hashmap value
        PriorityQueue <Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o1)-map.get(o2));
        for(int n : map.keySet()){
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }
        //建heap的前k个数的时候，要O(log1+log2+...+logk) = O(logk!) = O(klogk)
        //对于剩下n-k个element，每个要O(logk)，一共O((n-k)logk)
        //一共O(nlogk)

        //write answer from heap to output   ----- O(klogk)
        int[] output = new int[k];
        for(int i = 0; i < k; i++){
            //output.add(heap.poll());
            output[i] = heap.poll();
        }
        return output;
    }
}
//思路就是用hashmap记录每个element的frequence
//然后把每个element尝试插入min heap中，通过heap来达到排序和只留top k的结果

//Time: O(nlogk)
//Space: O(n+k) n for hashmap, k for heap

