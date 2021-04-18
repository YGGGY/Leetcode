package Greedy;
import java.util.*;

public class MaximumIceCreamBars_1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < costs.length; i++){
            sum += costs[i];
            if(sum <= coins)
                ans ++;
            else
                break;
        }
        return ans;
    }
}
