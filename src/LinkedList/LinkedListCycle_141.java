package LinkedList;

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)   return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
//use two pointer - fast pointer and slow pointer
//fast pointer move 2 steps at a time, slow pointer 1 step
//case 0: if there is no cycle, fast pointer will reach null at the end
//case 1: fast pointer is 1 step behind slow pointer, next iteration they will meet
//case 2: other cases, will turn into case 1

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }
