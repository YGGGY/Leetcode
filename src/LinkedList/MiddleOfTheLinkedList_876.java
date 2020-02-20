package LinkedList;

public class MiddleOfTheLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        ListNode[] ans = new ListNode[100];
        int len = 0;
        while(head.next != null){
            ans[len] = head;
            len++;
            head = head.next;
        }
        return ans[len/2];
        //奇数：5/2 = 2 是第三个数
        //偶数： 6/2 = 3 是3 4中后面那个数
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
