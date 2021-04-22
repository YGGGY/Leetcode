package DP;
import java.util.*;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    int temp = triangle.get(i-1).get(0) + triangle.get(i).get(j);
                    triangle.get(i).set(j, temp);
                }
                else if(j == i){
                    int temp = triangle.get(i-1).get(j-1) + triangle.get(i).get(j);
                    triangle.get(i).set(j, temp);
                }
                else{
                    int temp = Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)) + triangle.get(i).get(j);
                    triangle.get(i).set(j, temp);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j <= n-1; j++){
            ans = Math.min(triangle.get(n-1).get(j), ans);
        }
        return ans;
    }
}
