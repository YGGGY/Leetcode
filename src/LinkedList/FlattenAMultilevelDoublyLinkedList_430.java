package LinkedList;

public class FlattenAMultilevelDoublyLinkedList_430 {
    public Node flatten(Node head) {
        if(head == null) return null;

        Node curr = head;
        while(curr != null){
            if(curr.child == null){
                curr = curr.next;
            }
            else{
                Node temp = curr.child;
                while(temp.next != null){//temp是child chain的最后一个非空node
                    temp  = temp.next;
                }
                //child的chain遍历完，插入curr和curr.next之间
                temp.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = temp;

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};