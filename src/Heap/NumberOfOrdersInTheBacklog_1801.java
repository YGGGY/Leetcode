package Heap;
import java.util.*;

public class NumberOfOrdersInTheBacklog_1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1,o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);
        for(int[] order : orders){
            if(order[2] == 0){//buy
                int price = order[0], amount = order[1];
                while(amount > 0){
                    if(sell.isEmpty())//没有库存的sell了，减不了amount
                        break;
                    int[] temp = sell.poll();
                    if(temp[0] > price){ //最小的sell也比这个buy大，减不了amount
                        sell.add(temp); //把sell压回去
                        break;
                    }
                    else{
                        if(amount >= temp[1]){ //把这个price的sell单用完
                            amount -= temp[1];
                        }
                        else{
                            temp[1] -= amount; //这个price的sell单没用完就把amount清零了
                            amount = 0;
                            sell.add(temp); //把sell压回去
                        }
                    }
                }
                if(amount > 0) //还有没减掉的buy单
                    buy.add(new int[]{price, amount});//把剩下的buy单压进去
            }
            else{//sell
                int price = order[0], amount = order[1];
                while(amount > 0){
                    if(buy.isEmpty())//没有库存的buy了
                        break;
                    int[] temp = buy.poll();
                    if(temp[0] < price){
                        buy.add(temp);
                        break;
                    }
                    else{
                        if(amount >= temp[1]){
                            amount -= temp[1];
                        }
                        else{
                            temp[1] -= amount;
                            amount = 0;
                            buy.add(temp);
                        }
                    }
                }
                if(amount > 0)
                    sell.add(new int[]{price, amount});//把剩下的buy单压进去
            }
        }

        //count orders
        int sum1 = 0;
        int sum2 = 0;
        while(!sell.isEmpty()){
            int[] temp = sell.poll();
            sum1 += temp[1];
            sum1 %= 1000000007;
        }
        while(!buy.isEmpty()){
            int[] temp = buy.poll();
            sum2 += temp[1];
            sum2 %= 1000000007;
        }
        int sum = sum1+sum2;
        return sum %= 1000000007;
    }
}
