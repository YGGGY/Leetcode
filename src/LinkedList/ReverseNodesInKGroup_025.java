package LinkedList;

public class ReverseNodesInKGroup_025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //find k nodes
        ListNode pointer = head;
        int count = 0;
        while(count < k) {//往后找k个node，每次对k个node进行reverse
            if (pointer == null)
                return head;//less then k nodes left, return head of sub
            else {
                pointer = pointer.next;
                count++;
            }
        }

        ListNode prev = reverseKGroup(pointer, k);//prev = head of sub-problem
                                                // （后面找的k个node reverse之后的新head）
        //对目前k个node进行reverse
        while(count > 0){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            count--;
        }
        return prev;//prev是此时reverse后的head
    }
}
//所有几个几个一组reverse的做法的通解
//024（按pair reverse）做法一样

