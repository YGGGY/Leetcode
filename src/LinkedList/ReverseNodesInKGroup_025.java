package LinkedList;

public class ReverseNodesInKGroup_025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //find k nodes
        ListNode pointer = head;
        int count = 0;
        while(count < k) {
            if (pointer == null)
                return head;//less then k nodes left, return head of sub
            else {
                pointer = pointer.next;
                count++;
            }
        }

        ListNode prev = reverseKGroup(pointer, k);
        //prev = head of sub-problem
        while(count > 0){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            count--;
        }
        return prev;//prev是此时sub的head
    }
}
//所有几个几个一组reverse的做法的通解
//024（按pair reverse）做法一样

