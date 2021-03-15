package LinkedList;

public class SwappingNodesInALinkedList_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode current = head;
        int count = 0;
        while(current != null){
            count ++;
            if(count == k)
                left = current;
            if(count > k)
                right = right.next;
            current = current.next;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}
