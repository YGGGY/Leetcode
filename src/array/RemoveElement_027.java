package array;

public class RemoveElement_027 {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[ans++] = nums[i];//nums[ans] = nums[i]; ans++;
            }
        }
        return ans;
    }
    //ans用来记 去除后的number数
    //nums[0-ans]是想要的结果，后面还有一堆原nums的垃圾数据
    //注意是判断 nums[i] != val ，把需要的值存进去
}
