package array;

public class H_index_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];//建0~n的n+个桶
        //把有k个citations的paper放到第k个桶里
        for(int i = 0; i<n; i++){
            int citations0 = citations[i];
            if(citations0 >= n)//citations大于n的还是放在第n个桶里
                buckets[n]++;
            else
                buckets[citations0]++;
        }
        //从后往前遍历 总和>=index时，得到H-index
        //从后往前遍历而不是从前往后是为了得到最大的index
        int count = 0;
        for(int i=n; i>=0; i--){
            count += buckets[i];
            if(count >= i)
                return i;
        }
        return 0;
    }

}
