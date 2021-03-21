package SystemDesign;
import javafx.util.Pair;

import java.util.*;

public class DesignUndergroundSystem_1396 {
    //routeKey - totalTime, count 用来记这条路线的总时长和总次数，除一下就是要的结果
    private HashMap<String, Pair<Double, Double>> journey = new HashMap<>();
    //id - (checkIn station, time)
    private HashMap<Integer, Pair<String, Integer>> checkIn = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = checkIn.get(id);
        String startStation = pair.getKey();
        int checkInTime = pair.getValue();

        //取这个route之前的数据
        String routeKey = startStation + "->" + stationName;
        Pair<Double, Double> routeStats = journey.getOrDefault(routeKey, new Pair<>(0.0, 0.0));
        double totalTripTime = routeStats.getKey();
        double totalTrip = routeStats.getValue();

        //计算新的总时间和count，压入journey
        double tripTime = t - checkInTime;
        journey.put(routeKey, new Pair<>(totalTripTime+tripTime, totalTrip+1));

        checkIn.remove(id);//删掉checkin记录
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        double totalTime = journey.get(routeKey).getKey();
        double totalTrip = journey.get(routeKey).getValue();
        return totalTime/totalTrip;
    }
}
