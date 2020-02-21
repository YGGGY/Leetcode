package LinkedList;

public class ReverseLinkedList_206 {
    //Iteration
    //不用新建一个链表
    public ListNode reverseList(ListNode head) {
        //boundary case
        if(head == null || head.next == null)   return head;

        ListNode prev = null;
        ListNode curr = head;
        //prev-curr-temp
        //每次iterate右移
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;//将尾部的作为head
    }
    //新建一个链表的做法 参考21.Merge Two Sorted Lists


    //Recursion
    public ListNode reverseList2(ListNode head) {
        //base case
        if(head == null || head.next == null)   return head;

        ListNode p = reverseList2(head.next);//分成head和其他部分，递归其他部分
        head.next.next = head;//将head->head.next（其他部分的head）
                             // 变成head<-head.next（箭头反转）
        head.next = null;//head变成tail
        //1->  2<-3<-4<-5 变成 1<-2<-3<-4<-5
        return p;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}