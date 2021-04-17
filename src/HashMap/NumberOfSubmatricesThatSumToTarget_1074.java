package HashMap;
import java.util.*;

public class NumberOfSubmatricesThatSumToTarget_1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }

        int ans = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = i; j < m; j++){
                count.clear();
                count.put(0, 1);
                int sum = 0;
                for(int k = 0; k < n; k++){
                    int rowSum = 0;
                    if(i == 0)
                        rowSum = matrix[k][j];
                    else
                        rowSum = matrix[k][j] - matrix[k][i-1];
                    sum += rowSum;
                    if(count.containsKey(sum - target))
                        ans += count.get(sum - target);
                    count.put(sum, count.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
}

//相当于2D版的sum为k的subarray有多少个
//先求出每行的cumulative sum， 这样对于固定的列i和列j之间，该行的sum是可知的，为A[j] - A[i-1]
//遍历所有可能的列(i,j)组合，对于固定的列i和列j，视为1D版的一格，遍历0~n行，找有多少个sum为k的subarray


//Time: O(n * m^2)
//Space: O(mn)