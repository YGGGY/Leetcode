package SlidingWindow;
import java.util.*;

public class SubarraysWithKDifferentIntegers_992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return helper(A, K) - helper(A, K-1);
    }

    private int helper(int[] A, int K){
        HashMap<Integer, Integer> count = new HashMap<>();//int->times
        int left = 0;
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);

            while(count.size() > K){ //让left右移到有一个数的count为0（即成功删掉一个数）
                int leftNum = A[left];
                count.put(A[left], count.get(leftNum) - 1);
                if(count.get(A[left]) == 0)
                    count.remove(A[left]);
                left ++;
            }
            ans += i - left + 1;
            //窗口的长度就是新增的subarray个数，可以这样理解：
            //每次新增的right，自己算1个，自己和左边1位算1个，自己和左边2位算1个……自己和left算1个
            //总共增加窗口长度这么多个
        }
        return ans;
    }
}
//和340.Lonegest Subtstring with At Most K Distinct Characters是一种题
//这题要求刚好k个，其实就是最多k的结果-最多(k-1)个
//但是340求的是longest substring的长度，这题不用longest，只要符合条件就算，而且求的是数量而不是长度