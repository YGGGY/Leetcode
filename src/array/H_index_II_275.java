package array;

public class H_index_II_275 {
    public int hIndex(int[] citations) {
        int length =  citations.length;
        int left = 0;
        int right = length - 1;
        //binary search
        while(left <= right){  //注意这里要带=
            int middle = (left + right)/ 2;
            if(citations[middle] == length - middle)
                return length - middle;
            else if(citations[middle] < length - middle)// citations[index] < h
                left = middle + 1;
            else //citations[middle] > lenght - middle
                right = middle -1;
                //这个时候其实已经得到一个符合条件的h了，但是继续往前查找是为了找有没有更大的h
        }
        return length - left;
    }
}
// 整体的做法是用binary search
// h_index是h个paper都 ≥ h这个数
// 从后往前的h个是 h = length-index 这么多个，这h个都要 ≥ h
// 因为已经是sorted的，所以只要 第一个paper的数 ≥ h 就行
// 第一个paper的数是citations[index]，所以要citations[index] ≥ length-index
// 题目即为，找一个index，使得citations[index] ≥ length-index。通过binary search找

