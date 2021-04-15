package SlidingWindow;

public class MinimumSwapsToGroupAllOnesTogether_1151 {
    public int minSwaps(int[] data) {
        int ones = 0;//整个array里的1的数量
        for(int num : data){
            if(num == 1)
                ones ++;
        }

        int left = 0, right = ones-1;
        int current = 0;
        for(int i = 0; i < ones; i++){
            if(data[i] == 1)
                current ++;
        }
        int ans = ones-current;
        while(right < data.length-1){
            if(data[left] == 1)
                current --;
            left ++;

            right ++;
            if(data[right] == 1)
                current ++;

            ans = Math.min(ans, ones-current);
        }
        return ans;
    }
}

//这题slidingwindow倒没啥，主要是想明白swap数怎么算
//先找到整个array里1的数量，最后是要这些1全部集中在len为1的数量的subarray里面
//找所有len为1的数量的subarray，1最多的那个subarray里，0的数量就是最小的swap次数

//Time: O(n)
//Space: O(1)
