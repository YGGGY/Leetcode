package Recursion;
import java.util.*;

public class Permutations_II_047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        recursion(output, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return output;
    }

    private void recursion(List<List<Integer>> output, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length)
            output.add(new ArrayList<Integer>(temp));
        else{
            for(int i=0; i<nums.length; i++){
                                        //和前一个数字相同，这个数字没用过且前一个数字没用过，
                                        // 这种情况说明这个排列在前面的recursion已经用过了
                if(used[i] == true || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))
                    continue;
                used[i] = true;
                temp.add(nums[i]);
                recursion(output, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}

//这题里，虽然备用数字有重复的，但是同一个num不可以重复使用，所以用到used[]
//而combination sum那道题里，同一个数可以重复使用

//Combination Sum II的num也不可以重复使用，但是通过i=start, recursion(i+1)来使得数不会被重复使用。但是这题不能这么做
//因为Combination sum是把候选数从左到右一个个试，i是一直在变大。而这里是需要用到所有的候选数，i会有变小的情况

//这题里，[1,1,2]和[1,2,1]是两个不同的答案，所以每次i都是从0开始遍历
//Combination Sum那题，[2,2,3]和[2,3,2]是一个答案，所以要用i=start来记录现在用到哪个数了，保证不会再选到前面选过的数