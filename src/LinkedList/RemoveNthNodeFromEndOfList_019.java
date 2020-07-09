package LinkedList;

public class RemoveNthNodeFromEndOfList_019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)    return head;

        ListNode fast = head;//用来找最尾的null
        ListNode after = head;//被删节点的后一个点, after走n-1步到fast
        ListNode before = head;//被删节点的前一个点， before走2步到after

        for(int i = 0; i < n - 1; i++){
            fast = fast.next;
        }

        //corner case： 此时fast在最后一格，不能往后走2步
        if(fast.next == null)//这种情况下题意要删的是head
            return head.next;
        else{
            fast = fast.next.next;
            after = after.next.next;
        }


        while(fast != null){
            fast = fast.next;
            after = after.next;
            before = before.next;
        }
        before.next = after;
        return head;
    }
}
