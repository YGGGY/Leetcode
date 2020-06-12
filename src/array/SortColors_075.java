package array;

public class SortColors_075 {
    public void sortColors(int[] nums) {
        int curr = 0;
        int p0 = 0;//end of 0,
        //which means next 0 occurred will be on index p0
        int p2 = nums.length-1;//start of 2,which means occurred /

        while(curr <= p2 && p0 <= p2){
            if(nums[curr] == 0){
                //swap the number on curr with the number on p1
                nums[curr] = nums[p0];//nums[p0]是已经被检查过的1
                nums[p0] = 0;
                p0++;
                curr++;
            }
            else if(nums[curr] == 2){
                nums[curr] = nums[p2];//nums[p2]这个数还不知道是1还是0.所以这步curr不要+1
                nums[p2] = 2;
                p2--;
            }
            else{
                curr++;
            }
        }
    }
}
