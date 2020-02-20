package LinkedList;

public class MiddleOfTheLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        ListNode[] ans = new ListNode[100];
        int len = 0;
        while(head != null){
            ans[len] = head;
            len++;
            head = head.next;
        }
        return ans[len/2];
        //奇数：5/2 = 2 是第三个数
        //偶数： 6/2 = 3 是3 4中后面那个数
    }

    //第二种做法 快慢指针 节省空间
    //fast pointer到结尾的时候，slow pointer正好在中间
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){//<- fast的end
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
