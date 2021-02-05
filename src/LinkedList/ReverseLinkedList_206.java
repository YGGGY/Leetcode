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


    //Recursion
    public ListNode reverseList2(ListNode head) {
        //base case
        if(head == null || head.next == null)   return head;//base case

        ListNode p = reverseList2(head.next);//分成head和其他部分，递归其他部分
                                            //得到的p是剩余部分reverse之后的新head
        head.next.next = head;//将head->head.next（其他部分的head）
                             // 变成head<-head.next（箭头反转）
                            //不能写成p.next = head，因为p是剩余部分的head，后面还有别的node
        head.next = null;//主要是让最外这层head指向null
                        //中间步骤的temp_head这里指向null，return回上一层时会因为head.next.next=head这步而指向前一位
        return p;//p在每层recursion里都是头，所以不用担心head.next=null的问题
    }

}

