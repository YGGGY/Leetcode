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
    //Time: O(n^2)
    //Space: O(1)


    //----------------------------------------------------
    //不sort，把所有的数出现的次数存到map里
    //遍历ij，找剩余的数是否存在，存在的话计算组合数
    public int threeSumMulti2(int[] arr, int target) {
        long ans = 0;
        int n = arr.length;
        HashMap<Integer, Integer> count = new HashMap<>();//每个数字出现的次数
        for(int num : arr){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int i : count.keySet()){
            for(int j : count.keySet()){
                int remain = target - i - j;
                if(count.containsKey(remain)){
                    long count1 = count.get(i), count2 = count.get(j), count3 = count.get(remain);
                    if(i == j && j == remain) //3个数相等，C(3, n)
                        ans += count1 * (count1-1) * (count1-2) / 6;
                    else if(i == j)//i,j相等，另一个数不相等，C(2,n)* 另一个数数量
                                   //这个情况包括了所有2个数相等的情况，因为ij遍历包括所有组合
                        ans += count1 * (count1-1) / 2 * count3;
                    else if(i < j && j < remain){//3个数都不相等
                        ans += count1 * count2 * count3;
                    }
                    ans = ans % 1000000007;
                }
            }
        }

        return (int)(ans % 1000000007);
    }

    //---------------------------------
    public int threeSumMulti3(int[] arr, int target) {
        int ans = 0;
        int n = arr.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < n; i++){
            //和为target-arr[i]的双数组合，和arr[i]能凑出target
            ans = (ans + count.getOrDefault(target-arr[i], 0)) % 1000000007;
            for(int j = 0; j < i; j++){
                int sum = arr[i] + arr[j];//计算两个数字之和，count两数之和出现多少次
                count.put(sum, count.getOrDefault(sum, 0)+1);
            }
        }

        return ans;
    }
}
