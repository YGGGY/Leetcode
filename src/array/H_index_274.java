package array;

public class H_index_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;  //n个paper
        int[] buckets = new int[n+1];//建0~n的n+个桶
        //把有k个citations的paper放到第k个桶里
        for(int i = 0; i<n; i++){
            int citations0 = citations[i];
            if(citations0 >= n)//citations≥n的放在第n个桶里
                buckets[n]++;
            else
                buckets[citations0]++;
        }
        //从后往前遍历 总和>=index时，得到H index
        //从后往前遍历而不是从前往后是为了得到最大的index
        int count = 0;
        for(int i=n; i>=0; i--){
            count += buckets[i];
            if(count >= i)
                return i;//这里是return i而不是return count
                        //如果count == i那return哪个都ok
                        //如果count > i,说明有大于i个的paper的citation>=i，取其中i个，即有i个paper的citation大于等于i
        }
        return 0;
    }

}
