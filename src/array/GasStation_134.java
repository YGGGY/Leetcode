package array;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //先计算是否 油的总量 > 消耗的总量，>时才有解
        int tank = 0;
        for(int i=0; i<gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return -1;
        //有解后
        int start = 0;
        tank = 0;
        for(int i=0; i<gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(tank + curGain < 0){
                start = i + 1;
                tank = 0;
            }
            else
                tank += curGain;
        }
        return start;
    }
}
/*
假设在第k个加油站开始能一直走到最后，这里不需要重新走0到k-1来验证。可以看以下分析：
我们模拟一下过程：
a. 最开始，站点0是始发站，假设车开出站点p后，油箱空了，可知sum1 < 0；
b. 根据上面的论述，我们将p+1作为始发站，开出q站后，油箱又空了，可知sum2 < 0。
c. 将q+1作为始发站，假设一直开到了未循环的最末站，油箱没见底儿，可知sum3 >= 0。
只要sum3 + sum1 + sum2 >=0，车必然能开回q站。
而sum3 + sum1 + sum2 其实就是 diff数组的总和 Total，遍历完所有元素已经算出来了。
因此 Total 能否 >= 0，就是是否存在这样的站点的 充分必要条件。
参考一下链接https://www.cnblogs.com/felixfang/p/3814463.html
 */
