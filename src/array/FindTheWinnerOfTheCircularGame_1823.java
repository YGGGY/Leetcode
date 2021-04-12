package array;
import java.util.*;

public class FindTheWinnerOfTheCircularGame_1823 {
    public int findTheWinner(int n, int k) {
        int len = n;
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nums.add(i+1);
        }

        int start = 0;
        while(len != 1){
            int delete = (start + k - 1) % len;
            nums.remove(delete);
            len --;
            start = (delete)%len;
        }
        return nums.get(0);
    }
}
