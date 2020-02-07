package array;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] result = new int[length];
        left[0] = nums[0];
        right[length-1] = nums[length-1];

        for(int i = 1; i < length; i++){
            left[i] = left[i-1] * nums[i];
        }
        for(int i = length-2; i > 0; i--){
            right[i] = right[i+1] * nums[i];
        }
        for(int i = 1; i < length-1; i++){
            result[i] = left[i-1] * right[i+1];
        }
        result[0] = right[1];
        result[length-1] = left[length-2];
        return result;
    }
}

//the product of the other and be get by multiply left part and right part
//use arrays left[] and right[] to record the product of left part and right part
