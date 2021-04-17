package DFSnBFS;
import java.util.*;

public class TheMaze_490 {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0 || speed.length == 0)  return 0;
        int n = position.length;
        Car[] cars = new Car[n];
        for(int i = 0; i < n; i++){
            Car car = new Car();
            car.position = position[i];
            car.arriveTime = (double)(target-position[i])/speed[i];
            cars[i] = car;
        }
        //按position的位置来排，遍历的时候比较前后车的速度
        //两车相遇时，速度只会变慢不会变快。从后往前找是否相遇，相遇了视为同一个（速度较慢那个），再比较后面的车
        Arrays.sort(cars, (car1, car2) -> car1.position - car2.position);

        int ans = 0;
        n--;
        double slow = 0;
        while(n >= 0){
            //如果当前车比前面车队还慢，不会遇上，且可能成为新的车队头
            //如果当前车比前面车队快，则会遇上，并成为车队的一部分
            if(cars[n].arriveTime > slow){
                slow = cars[n].arriveTime;
                ans ++;
            }
            n--;
        }
        return ans;
    }

    class Car{
        int position;
        double arriveTime;
    }
}
