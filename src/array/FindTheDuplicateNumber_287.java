package array;

public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);

        slow = nums[0];
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
//这题关键是明白怎么弄出来个圈 然后用快慢指针做
//怎么形成圈呢：让nums[i]这个数指向index==nums[i]的那个数，即nums[i]下一个数是nums[nums[i]]，最后会有一个圈