package LinkedList;

public class SwapNodesInPairs_024 {
    public ListNode swapPairs(ListNode head) {
        ListNode pointer = head;
        int count = 0;
        while(count < 2){
            if(pointer == null)
                return head;
            else{
                pointer = pointer.next;
                count++;
            }
        }

        ListNode prev = swapPairs(pointer);
        while(count > 0){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            count--;
        }
        return prev;
    }
}
//和025做法一样
