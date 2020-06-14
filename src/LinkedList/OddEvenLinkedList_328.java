package LinkedList;

public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)    return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        //奇数个数的node的话，最后一次开始时是 odd==倒数第三个，even==倒数第二个；结束后 odd==倒数第一，even==null
        //偶数个数的node的话，最后一次开始时是 odd和even是倒数第二对； 结束后 odd和even是最后一对
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
