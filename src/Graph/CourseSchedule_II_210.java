package Graph;
import java.util.*;

public class CourseSchedule_II_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[]  = new int[numCourses];
        int ans[] = new int[numCourses];
        int index = 0;

        for(int[] pre : prerequisites){//计算每个node的入度，注意题目是(ai,bi):bi->ai
            indegree[pre[0]] ++;
        }

        //找入度为0的node，加入queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }

        //提出入度为0的点start，加入ans，去掉以这些点为起点的边，把对应终点的入度减1，再把入度为0的加入queue
        while(!queue.isEmpty()){
            int start = queue.poll();
            ans[index] = start;
            index ++;
            for(int i = 0 ; i < prerequisites.length; i++){
                if(prerequisites[i][1] == start){
                    indegree[prerequisites[i][0]] --;
                    if(indegree[prerequisites[i][0]] == 0)//终点变成入度为0的点的话，压入queue
                        queue.offer(prerequisites[i][0]);
                }
            }
        }

        if(index == numCourses)//判断是否所有课都放入ans了，如果不是都放入，说明有环，不符合条件
            return ans;
        else
            return new int[0];
    }
    //kahn算法，①找入度为0的点，取出 ②删除这个点和以它为起点的edge ③重复1和2
    //这题是用adjacent matrix来表示edge的，每次取出vertex时找edge都遍历了一遍
    //Time: O(V * E)，如果用hashmap保存edge的话，就可以V+E
    //Space: O(V)
}
