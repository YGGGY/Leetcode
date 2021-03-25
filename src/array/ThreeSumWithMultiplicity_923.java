package array;
import java.util.*;

public class ThreeSumWithMultiplicity_923 {
    //-------------------------------------------
    //sort以后，对每个i用two pionter找另外两个数left和right
    //如果有重复的left和right，找到有几个。如果left!=right就数量相乘，如果left==right就C(2,n)
    public int threeSumMulti(int[] arr, int target) {
        long ans = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < n-2; i++){
            int tempSum = target - arr[i];
            int left = i + 1, right = n - 1;
            while(left < right){
                if(arr[left] + arr[right] < tempSum)
                    left++;
                else if(arr[left] + arr[right] > tempSum)
                    right--;
                else{
                    int numLeft = 1, numRight = 1;//找等于left和right的数有多少个
                    while(left + numLeft < right && arr[left] == arr[left + numLeft])
                        numLeft ++;
                    while(right - numRight >= left + numLeft && arr[right] == arr[right - numRight])
                        numRight ++;
                    if(arr[left] == arr[right]) // left == right, 组合数公式n个里面取2个
                        ans += (right - left + 1) * (right - left) / 2;
                    else  //left != right，直接数量相乘
                        ans += numLeft * numRight;
                    left += numLeft;
                    right -= numRight;
                }
            }
        }
        return (int)(ans % 1000000007);
    }
}
