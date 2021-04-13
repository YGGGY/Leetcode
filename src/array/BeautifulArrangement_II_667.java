package array;

public class BeautifulArrangement_II_667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int min = 1, max = n;
        for(int i = 0; i < n; i++){
            if(k % 2 == 0){
                ans[i] = min;
                min ++;
            }
            else{
                ans[i] = max;
                max --;
            }

            if(k - 1 > 0)
                k--;
        }
        return ans;
    }
}
/*
k=1: 1 2 3 4 5 6 | 6 5 4 3 2 1
k=2: 1 6 5 4 3 2 | 6 1 2 3 4 5
k=3: 1 6 2 3 4 5 | 6 1 5 4 3 2
k=4: 1 6 2 5 4 3 | 6 1 5 2 3 4

其实就是前面k-1个数剩余max和剩余min交替，
    然后后面n-k+1个数，如果k为奇升序，如果k为偶降序
 */
