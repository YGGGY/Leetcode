package Heap;
import java.util.*;

public class FurthestBuildingYouCanReach_1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < heights.length-1; i++){
            int diff = heights[i+1] - heights[i];
            if(diff > 0)//上升
                heap.add(diff);
            if(heap.size() > ladders)
                bricks -= heap.poll();
            if(bricks < 0)//bricks用完了，走不到下一步了
                return i;
        }
        return heights.length - 1;//能走完，返回最后一个index
    }
}
//大的diff尽量用ladder，小的再用bricks，bricks用完的时候就不能再往前走了
//用min heap存diff，heap大小为ladder，超过ladder个就poll出来用brick来凑，这样当前最大的几个都是用ladder
//Time: O(nlogk)
//Space: O(k)