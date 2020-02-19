package LinkedList;

public class IntersectionOfTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = (a != null)? a.next : headB;
            b = (b != null)? b.next : headA;
        }
        return a;
    }
}

//a and b initialized at the head of A and B, repsectively
//let a and b traverse through the lists
//when reaches the end of the list, redirect to the head of the other list
//in the second iteration, two pointer are guaranteed to reach the intersection at the same time

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}