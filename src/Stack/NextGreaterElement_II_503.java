package Stack;
import java.util.*;

public class NextGreaterElement_II_503 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null)    return null;

        Deque<Integer> stack = new ArrayDeque<>();
        int length = nums.length;
        int[] res = new int[length];

        for(int i = length*2-1; i >= 0; i--){//用length*2来走2遍，用i%length来取到对应的i
            while(!stack.isEmpty() && nums[i%length] >= nums[stack.getFirst()]){
                stack.pop();
            }

            if(stack.isEmpty())//后面没有比他大的
                res[i%length] = -1;
            else //nums[i] < nums[head]
                res[i%length] = nums[stack.peek()];

            stack.push(i%length);
        }

        return res;
    }
}

//Time: O(n)
//Space: O(n)

//暴力解法是跑2次，每个nums[i]和后面的数进行对比
//题解的做法是取当前较大值进行比较，小了的话取下一个较大值