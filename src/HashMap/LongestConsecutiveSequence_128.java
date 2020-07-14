package HashMap;
import java.util.*;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();//<n, length of sequence where n is in>

        for(int n : nums){
            if(map.containsKey(n))//数字n之前已经出现过了，不用重复处理
                continue;
            else{
                //if n-1, n+1 exist in the map, left/right is the length of sequence next to n
                int left = (map.containsKey(n-1))? map.get(n-1) : 0;
                int right = (map.containsKey(n+1))? map.get(n+1) : 0;

                int sum = left + right + 1;
                map.put(n, sum);

                //update existed sequence length（只更新头尾的数）
                map.put(n - left, sum);
                map.put(n + right, sum);
                //如果n两边都不连上sequence，left==0, right==0，不会改变
                //如果n连上左边/右边，n是这个sequence的尾/头，只要再更新另一端的
                //如果n两边都连上了，那n-left和n+right就是这个新sequence的两端

                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
//用HashMap记录每个点和所在sequence的长度
//遍历每个点，更新sequence长度