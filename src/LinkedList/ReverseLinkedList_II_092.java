package LinkedList;

public class ReverseLinkedList_II_092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode prev = head;
        ListNode current = head;
        while(count < left){
            if(count > 1)
                prev = prev.next;
            current = current.next;
            count ++;
        }

        ListNode firstEnd = prev;
        ListNode changeStart = current;
        prev = null;
        while(count <= right){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            count ++;
        }
        if(left != 1) //left不是开头第一个
            firstEnd.next = prev;
        if(current != null) //right不是最后那个
            changeStart.next = current;
        if(left != 1)
            return head;
        else
            return prev;
    }
}
