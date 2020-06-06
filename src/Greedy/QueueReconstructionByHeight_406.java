package Greedy;
import java.util.*;

public class QueueReconstructionByHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        //sort int[][] people
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0])
                    return o2[0] - o1[0];//height descending
                else
                    //if heights are equal, sort k-values in ascending order
                    return o1[1] - o2[1];
            }
        });

        List<int[]> output = new LinkedList<>();//用linkedlist插入更方便，用array插入还要把后面的往后挪
        for(int[] p:people){//二维数组people的每项是一个array
            output.add(p[1], p);//在index==k-value处插入
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
//Sort the tallest guy in ascending↑ order by k-value, and insert into queue at the indexes equal to k-value.
//Take the next height in descending↓ order.
// Also sort these guys in ascending order by k-value, and insert into queue at the indexes equal to k-value.
//为什么可以这样做呢？因为:
//Smaller persons are invisible for the taller ones. Then insersion of them won't change the correctness of taller ones.
//For smaller persons, the number of index means there are exactlly such persons taller or equal to them.