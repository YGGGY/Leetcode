package LinkedList;

public class IntersectionOfTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = (a != null)? a.next : headB;
            b = (b != null)? b.next : headA;
            //注意这里不能用a.next != null来判断
            //当两个LinkedList没有intersection的时候，a和b同时到达结尾的null，此时a==b
            //不能跳过这个null
        }
        return a;
    }
}

//a and b initialized at the head of A and B, repsectively
//let a and b traverse through the lists
//when reaches the end of the list, redirect to the head of the other list
//in the second iteration, two pointer are guaranteed to reach the intersection at the same time
