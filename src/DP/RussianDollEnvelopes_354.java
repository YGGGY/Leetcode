package DP;
import java.util.*;

public class RussianDollEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];//第一维升序
                else
                    //第一维相同时，第二维降序，使小的那个会在大的后面，和大的放在同一个pile，这样不会都加入LIS
                    return o2[1] - o1[1];
            }
        });

        int[] envelope = new int [envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            envelope[i] = envelopes[i][1];
        }

        int[] piles = new int[envelope.length];
        int numOfPiles = 0;
        for(int enve : envelope){
            int destPile = Arrays.binarySearch(piles, 0, numOfPiles, enve);
            if(destPile < 0)
                destPile = - (destPile + 1);
            piles[destPile] = enve;
            if(destPile == numOfPiles)
                numOfPiles ++;
        }
        return numOfPiles;
    }
}

//Time: O(nlogn) sort array和找LIS都是nlogn时间
//Space: O(n)
