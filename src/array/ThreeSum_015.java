package array;
import java.util.*;

public class ThreeSum_015 {
    //--------------------------------------------------
    //对一个选定的数nums[i]，再找两个数，使两数之和为-nums[i]
    //用two pointer做，和Two Sum II做法一样----注意能这么做是因为是sorted后的
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i == 0 || nums[i] != nums[i-1]){//去掉相同的数
                int left = i + 1, right = nums.length-1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0){
                        List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                        output.add(temp);
                        left++;
                        right--;
                        while(nums[left] == nums[left-1] && left < right){ //去掉相同的数
                            left ++;
                        }
                    }
                    else if(sum < 0)
                        left ++;
                    else
                        right --;
                }
            }
        }
        return output;
    }
    //Time: O(n^2)

    //-----------------------
    //另一种做法，也是要sort，然后i从0开始取。然后剩下两个数和two sum一样，用one pass+hashset来找
    //Time也是O(n^2)



    //------------------------------------------------
    //不用sort， 遍历ij，找剩余的那个数在不在
    public List<List<Integer>> threeSum2(int[] nums) {
        HashSet<List<Integer>> output = new HashSet<>(); //用set来去掉重复的结果
        HashSet<Integer> duplicate = new HashSet<>();  //去除nums里重复的数
        HashMap<Integer, Integer> visited = new HashMap<>(); //nums[j]->i，每个i的visited单独来看
        for(int i = 0; i < nums.length; i++){
            if(!duplicate.contains(nums[i])){ //重复的数直接跳过
                duplicate.add(nums[i]);
                for(int j = i + 1; j < nums.length; j++){
                    int complement = -nums[i] - nums[j];
                    //在这个i的轮次找到过complement
                    if(visited.containsKey(complement) && visited.get(complement) == i){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(temp);
                        output.add(temp);
                    }
                    visited.put(nums[j], i);
                }
            }
        }
        return new ArrayList(output);
    }

}
