package Heap;
import java.util.*;

public class TopKFrequentWords_692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> output = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(map.get(s1) < map.get(s2))
                    return 1;
                else if(map.get(s2) < map.get(s1))
                    return -1;
                else
                    return s1.compareTo(s2);
            }
        });

        for(String word: map.keySet()){
            heap.offer(word);
        }

        for(int i = 0; i < k; i++){
            output.add(heap.poll());
        }
        return output;
    }
}

//Time:O(nlogn)
// 如果把最大堆改成最小堆，heap大小超过k时poll(),最后再反向加到output，可以减到O(nlogk)，因为heap.offer只花logk了
//Space: O(n)