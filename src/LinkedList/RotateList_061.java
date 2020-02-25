package LinkedList;

public class RotateList_061 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)  return head;

        int n = 1;
        ListNode count = head;
        while(count.next != null){
            count = count.next;
            n++;
        }
        count.next = head;//连成环

        //第n - (k % n)的点是新的tail，下一个点是新的head
        ListNode new_tail = head;
        for(int i = 0; i < n - k % n - 1; i++){//从head往后走n - (k % n) - 1步
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next = null;//断掉环
        return new_head;
    }
}
