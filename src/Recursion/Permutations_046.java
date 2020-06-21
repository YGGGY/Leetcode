package Recursion;
import java.util.*;

public class Permutations_046 {
    //通解
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        recursion(output, new ArrayList<>(), nums);
        return output;
    }

    private void recursion(List<List<Integer>> output, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length)
            output.add(new ArrayList<>(temp));//一定要记得new一个ArrayList！！！！
        else{
            for(int i=0; i < nums.length; i++){
                if(temp.contains(nums[i]))//element already exists
                    continue;
                temp.add(nums[i]);
                recursion(output, temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }





    //------------------------------------------
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();

        //把nums变成ArrayList，因为后面swap要对list类型的nums进行操作，并且以list的类型存进output里
        ArrayList<Integer> nums_list = new ArrayList<Integer>();
        for(int num : nums){
            nums_list.add(num);
        }

        int n = nums.length;
        recursion(n, nums_list, output, 0);
        return output;
    }

    public void recursion(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first){
        if(first == n)//base case 遍历完了
            output.add(new ArrayList<Integer>(nums));//这里要new一个ArrayList
                                    //如果直接用output.add(nums)的话，会导致之前add的list也变成了这个最新的nums
                                    //这是因为list of list实际上是通过保存reference of heap来保存的，所有的nums都被解析了成最新的nums

        //从index==first到index==n-1，将nums[first]和nums[i]交换
        for(int i = first; i < n; i++){
            Collections.swap(nums, first, i);
            recursion(n, nums, output, first+1);
            Collections.swap(nums, first, i);//return前交换回来 Make sure后续的调用的时候是对的
        }
    }



}
