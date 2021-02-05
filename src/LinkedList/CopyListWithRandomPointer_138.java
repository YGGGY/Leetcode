package LinkedList;
import java.util.*;

public class CopyListWithRandomPointer_138 {

    //利用HashMap来建立node和新list里的node的一一对应关系
    public Node copyRandomList(Node head) {
        if(head == null)    return null;

        Node dummy = new Node(0);//copy出来的新的list的dummy head
        Node curr = dummy;
        Map<Node,Node> map = new HashMap<>();

        while(head != null){
            if(!map.containsKey(head)){//检查node有没有被copy过
                map.put(head, new Node(head.val));//存到hashmap里
            }

            curr.next = map.get(head);//从hashmap获取copy node，存入新的list

            //处理random pointer
            if(head.random != null){
                if(!map.containsKey(head.random)){//检查random pointer指向的node是否已经被copy过
                    map.put(head.random, new Node(head.random.val));//把random point存入hashmap
                }
                curr.next.random = map.get(head.random);//copy random pointer
            }

            head = head.next;
            curr = curr.next;
        }
        return dummy.next;
    }
    //val值在存入hashmap时copy，random单独处理，next通过iteration处理
    //Time: O(n)
    //Space: O(n)

    //------------------------------------
    //这个方法不需要额外新增hashmap
    //在原本的linkedlist上，把copy node放到原本的node之后
    //新copy node的random pointer指向对应的copy node
    //最后extract copy node成单独的list
    public Node copyRandomList2(Node head) {
        if(head == null) return null;

        //遍历一遍
        //在每个node的后面加一个copy node
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);//复制val
            copy.next = curr.next;//复制next
            curr.next = copy;//插到后面
            curr = curr.next.next;//复制下一个点
        }

        //遍历第二遍
        //处理random pointer
        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;//random pointer指向对应的copy node
            curr = curr.next.next;//处理下一个点
        }

        //遍历第三遍
        //extract copy node
        curr = head;
        Node dummy = new Node(0);//新list的dummy node
        Node new_copy = dummy;
        while(curr != null){
            //把copy node复制到新的list上
            new_copy.next = curr.next;
            new_copy = new_copy.next;

            //删掉copy node
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }



}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}