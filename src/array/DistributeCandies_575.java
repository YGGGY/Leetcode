package array;
import java.util.*;

public class DistributeCandies_575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for(int candy : candyType){
            set.add(candy);
        }
        return Math.min(candyType.length/2, set.size());
    }

    //---------------------------
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int type = 1;

        for(int i = 1 ; i < candyType.length; i++){
            if(candyType[i] != candyType[i-1])
                type++;
        }

        return Math.min(type, candyType.length/2);
    }
}
//两种做法的不同在于怎么找candy的种类数