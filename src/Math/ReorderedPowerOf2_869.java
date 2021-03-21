package Math;
import java.util.*;

public class ReorderedPowerOf2_869 {
    public boolean reorderedPowerOf2(int N) {
        int digits[] = count(N);
        for(int i = 1; i <= 32; i++){
            int digits2[] = count(1 << i);
            if(Arrays.equals(digits, digits2))
                return true;
        }
        return false;
    }

    private int[] count(int n){
        int digits[] = new int[10];
        while(n > 0){
            int temp = n % 10;
            digits[temp] ++;
            n /= 10;
        }
        return digits;
    }
}
