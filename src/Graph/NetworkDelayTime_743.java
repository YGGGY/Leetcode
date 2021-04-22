package Graph;

public class NetworkDelayTime_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>(); // node -> list of [node, time]
        for(int[] edge : times){ //建graph
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        //每次取离k最近的还没visit过的点
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);//[node,到k的dis]
        boolean[] visited = new boolean[n+1];
        int[] minDis = new int[n+1];//k点到各个点的最短距离，初始为无穷， 到k点为0
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[k] = 0;
        heap.offer(new int[]{k, 0});

        int ans = 0;
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int currNode = curr[0];
            if(visited[currNode])  continue;
            visited[currNode] = true;
            int currDis = curr[1];
            ans = currDis;
            n--;
            if(!map.containsKey(currNode))  continue;
            for(int[] next : map.get(currNode)){//对curr的每个邻接点，更新到x的距离
                if(!visited[next[0]] && currDis + next[1] < minDis[next[0]])
                    heap.offer(new int[]{next[0], currDis + next[1]});
            }
        }

        if(n == 0)
            return ans;
        else //有点是unreachable
            return -1;
    }
}
