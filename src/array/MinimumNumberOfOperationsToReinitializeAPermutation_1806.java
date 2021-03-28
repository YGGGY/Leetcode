package array;
import java.util.*;

public class MinimumNumberOfOperationsToReinitializeAPermutation_1806 {
    public int reinitializePermutation(int n) {
        int count = 1;
        int[] arr = new int[n];
        int[] perm = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
            perm[i] = i;
        }

        int[] temp = arr.clone();
        for(int i = 0; i < n; i++){
            if(i % 2 == 0)
                arr[i] = temp[i/2];
            else
                arr[i] = temp[n/2 + (i-1)/2];
        }

        while(!Arrays.equals(arr, perm)){
            temp = arr.clone();
            for(int i = 0; i < n; i++){
                if(i % 2 == 0)
                    arr[i] = temp[i/2];
                else
                    arr[i] = temp[n/2 + (i-1)/2];
            }
            count ++;
        }
        return count;
    }
}
