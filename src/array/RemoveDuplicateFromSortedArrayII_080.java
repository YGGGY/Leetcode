package array;

public class RemoveDuplicateFromSortedArrayII_080 {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for(int i = 0;i < nums.length; i++){
            if(n < 2 || nums[i] > nums[n-2]){
                //只考虑是否大于往前数前2个数，不用考虑前一个数是否重复
                nums[n] = nums[i];
                n++;//只有满足的情况会让这个数写入想要的nums中，然后n++
            }
        }
        return n;
    }
}
