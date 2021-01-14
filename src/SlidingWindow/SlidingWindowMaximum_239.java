package SlidingWindow;
import java.util.*;

public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //维护一个递减的deque，存index来代表nums里的数
        //同一个窗口里，加入一个新的数curr，如果curr比最后的数大，删除已存的数，
        //如果curr比最后的数小，保留，虽然curr不会是现在的window里的max，但可能是以后windows里的potential max
        //每一步都是加的更小的，所以是个递减的deque
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        if(k == 1)  return nums;
        int max = 0;
        //push first k nums
        for(int i = 0; i < k; i++){
            //待加入的curr，如果有比curr小的-->删掉
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.removeLast();

            deque.addLast(i);
            if(nums[i] > nums[max])
                max = i;
        }

        int[] output = new int[n-k+1];
        output[0] = nums[max];

        //逐步滑动窗口
        for(int i = k; i < n; i++){
            //window从i-k+1到i共k个，i-k是上个window的元素，要删掉
            if(!deque.isEmpty() && deque.getFirst() == i-k)
                deque.removeFirst();

            //待加入的curr，如果有比curr小的-->删掉
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.removeLast();

            deque.addLast(i);
            output[i-k+1] = nums[deque.getFirst()];
        }
        return output;
    }
}
