package Greedy;
import java.util.*;

public class AdvantageShuffle_870 {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] sortedA = A.clone();
        int[] sortedB = B.clone();
        Arrays.sort(sortedA);
        Arrays.sort(sortedB);

        //B[i]和对应的比B[i]大的A[j]
        HashMap<Integer, Deque<Integer>> candidate = new HashMap<>();
        for(int b : B){
            candidate.put(b, new ArrayDeque());
        }

        Deque<Integer> remaining = new ArrayDeque();

        int index = 0;
        for(int a : sortedA){
            if(a > sortedB[index]){//把大于b的放进b对应的candidate stack里
                candidate.get(sortedB[index]).push(a);
                index ++;
            }
            else
                remaining.push(a);
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            if(candidate.get(B[i]).size() > 0)
                ans[i] = candidate.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }

        return ans;
    }
}
