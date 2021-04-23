package array;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = nums[0];
        for(int i = 1; i < n; i++){
            left[i] = left[i-1] * nums[i];
        }
        right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i];
        }

        result[0] = right[1];
        result[n-1] = left[n-2];
        for(int i = 1; i < n-1; i++){
            result[i] = left[i-1] * right[i+1];
        }
        return result;
    }

//算出从左往右乘积left[]，从右往左乘积right[]， result[i] = left[i-1] * right[i+1]
//Time:O(n)
//Space: O(n)


//-----------------------------------------------
//节省空间的做法，从左往右的乘积直接记录在result里，再从右往左时用right变量记录right部分，直接当场计算result[i]
public int[] productExceptSelf2(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    result[0] = nums[0];
    for(int i = 1; i < n-1; i++){//从第一个乘到到倒数第二个
        result[i] = result[i-1] * nums[i];
    }

    result[n-1] = result[n-2];//最后的数为前n-1个数之积
    int right = nums[n-1];
    for(int i = n-2; i >= 1; i--){ //right从倒数第二个数乘到第二个数
        result[i] = result[i-1] * right;
        right *= nums[i];
    }
    result[0] = right;

    return result;
}
}
