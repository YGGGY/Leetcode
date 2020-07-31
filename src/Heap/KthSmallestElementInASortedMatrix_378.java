package Heap;
import java.util.*;

public class KthSmallestElementInASortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int numOfRows = matrix.length;
        int num = Math.min(numOfRows, k);//如果k<行数，只取k行即可
        //把每行第一个压入min heap
        PriorityQueue <MyNode> heap = new PriorityQueue<MyNode>(num, (o1, o2) -> o1.value-o2.value);
        for(int r = 0; r < num; r++){
            heap.add(new MyNode(matrix[r][0], r, 0));
        }

        //取heap的头，即目前最小值，然后把这行下一个值加到heap中。重复k次之后，当前的head就是第7大
        MyNode curr = heap.peek();
        while(k > 0){
            curr = heap.poll();
            int row = curr.row;
            int column = curr.column;

            if(column < num - 1)
                heap.add(new MyNode(matrix[row][column+1], row, column+1));

            k--;
        }

        return curr.value;
    }
}

class MyNode{
    int value;
    int row;
    int column;

    public MyNode(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
    }

}
//解题思路：
//因为每行内部是sorted的，每行的第一个压入min heap，heap的当前head就是最小的
//然后把head poll出来，将head所在行的下一个元素压入heap。重复这个过程k次，当前head即为第7小的
//为了能取到head所在行，需要记录row和column值，所以新建了一个类

//关于heap：
//因为这个matrix的行和列是sorted，所以每次取出来的min heap的头一定是目前最小的
//取出目前最小的点，读他的row值来往下找下一个。所以每次取最小的，所以是用Min heap
//其他题取kth smallest的时候不能这么想，因为如果用min heap的话，也不能保证取出来的head是当前剩余数中最小的，而是要全部过一遍，剩下k个最小的

//let X = min(numOfRows, k)
//Time: O(X + klogX) X--建堆 klogX--k次插入heap
//Space: O(X)