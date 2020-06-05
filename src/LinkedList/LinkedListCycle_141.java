package LinkedList;

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)   return false;//记得判断head！！！！

        ListNode slow = head;
        ListNode fast = head.next;//注意fast设为head.next 因为我们要套圈
                                //但是在middle of LinkedList时fast=head，因为要两倍slow

        while(slow != fast){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //另一种写法
    //快慢指针初始一样
    public boolean hasCycle2(ListNode head) {
        if(head==null || head.next ==null)  return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
//use two pointer - fast pointer and slow pointer
//fast pointer move 2 steps at a time, slow pointer 1 step
//case 0: if there is no cycle, fast pointer will reach null at the end
//case 1: fast pointer is 1 step behind slow pointer, next iteration they will meet
//case 2: other cases, will turn into case 1

