package array;
import java.util.*;

public class LargestUniqueNumber_1133 {
    //-----------------------------------------
    //先sort，然后找不重复的最大值
    public int largestUniqueNumber(int[] A) {
        Arrays.sort(A);
        for(int i = A.length-1 ; i >= 0; i--){
            if(i == 0)
                return A[0];
            if(A[i] != A[i-1])
                return A[i];
            while(i > 0 && A[i-1] == A[i]){
                i--;
            }
        }
        return -1;
    }
    //Time: O(nlogn)
    //Space: O(1)


    //---------------------------------------
    //用hashmap记录出现的次数
    public int largestUniqueNumber2(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a : A){
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        int max = -1;
        for(int key : map.keySet()){
            if(map.get(key) == 1)
                max = Math.max(max, key);
        }
        return max;
    }
}
