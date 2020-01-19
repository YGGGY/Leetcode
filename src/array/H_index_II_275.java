package array;

public class H_index_II_275 {
    public int hIndex(int[] citations) {
        int length =  citations.length;
        int left = 0;
        int right = length - 1;
        //binary search
        while(left <= right){  //注意这里要带=
            int mid = (left + right)/ 2;
            if(citations[mid] == length - mid)
                return length - mid; //mid正好是要找的index
            else if(citations[mid] < length - mid)
                left = mid + 1; //往后边查
            else //citations[mid] > length - mid
                right = mid -1; //往前面查
                //这个时候其实已经得到一个符合条件的h了，但是继续往前查找是为了找有没有更大的h
        }
        return length - left;
        //left>right跳出循环说明，在上一次的left=middle+1前，left==right，已经找到头了
        // 为什么取left==right时的后面一个index是对的呢？
        // 因为造成left==right前，要么是right = mid-1，这时这个mid是可行的中最左边的
        //                      要么是left = mid+1，一直往后查已经查无可查了
    }
}
// 整体的做法是用binary search
// h_index是h个paper都 ≥ h这个数
// 从后往前的有 length-index 这么多个，这些都要 ≥ h
// 因为已经是sorted的，所以只要 第一个paper的citation数 ≥ h 就行
// 第一个paper的数是citations[index]，所以要citations[index] ≥ length-index
// 题目即为，找一个index，使得citations[index] ≥ length-index。通过binary search找

