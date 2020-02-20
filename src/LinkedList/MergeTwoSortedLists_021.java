package LinkedList;

public class MergeTwoSortedLists_021 {
    //recursion
    //O(n+m)time, O(n+m)space
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        else if(l2 == null) return l1;
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //iteration
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pointer = dummyHead;
        //pointer is used to go through two lists and build new linked list
        //dummyHead.next alwasy points to the head of new list
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pointer.next = l1;
                l1 = l1.next;
            }
            else{
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = (l1 == null)? l2 : l1;
        return dummyHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
