package LinkedList;

public class RemoveNthNodeFromEndOfList_019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)    return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode before = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        if(fast!= null){
            fast = fast.next;
            slow = slow.next;
        }
        else{//slow都不能动，fast已经到null了，说明删的是head
            return head.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
            before = before.next;
        }

        before.next = slow.next;
        return head;
    }
}
