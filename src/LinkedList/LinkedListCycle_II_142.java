package LinkedList;

public class LinkedListCycle_II_142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)   return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

        //find intersect node
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        //no cycle
        if(meet == null)    return null;

        //run again to find the start node of cycle
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

//这题的关键在于想通怎么找到这个点
//通过计算可以得出，head到cycle起始点的距离 == 相遇点到cycle起始点的距离
