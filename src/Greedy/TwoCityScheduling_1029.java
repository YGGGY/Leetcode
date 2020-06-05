package Greedy;

public class TwoCityScheduling_1029 {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        int[] dif = new int[n*2];
        int cost = 0;

        for(int i=0; i< n*2; i++){
            dif[i] = costs[i][1] - costs[i][0];//cost of B - cost of A
            cost += costs[i][0];//let 2N people go to A
        }

        Arrays.sort(dif);
        for(int i=0; i<n; i++){
            cost += dif[i];//get the refund of go to B
        }
        return cost;
    }
}

//注意题目的意思是，要有N个人去A，N个人去B,找支出最小的数字
//First let all of the 2n people go to location A, get the total cost
//Then subtract the cost of B from cost of A, that is, how much "refund we will get"/ "have to pay" to go to B instead
//sort the array of difference, and we get the cheapest way to let n people go to B
//add first n dif to total cost to get the result
