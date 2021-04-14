package LinkedList;

public class PartitionList_086 {
    public ListNode partition(ListNode head, int x) {
        if(head == null)    return null;

        ListNode beforeHead = new ListNode(0);
        ListNode beforeCurr = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode afterCurr = afterHead;
        ListNode curr = head;

        while(curr != null){
            if(curr.val < x){
                beforeCurr.next = curr;
                beforeCurr = beforeCurr.next;
            }
            else{
                afterCurr.next = curr;
                afterCurr = afterCurr.next;
            }
            curr = curr.next;
        }
        afterCurr.next = null;
        beforeCurr.next = afterHead.next;
        return beforeHead.next;
    }
}
