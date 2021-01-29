package LinkedList;

public class AddTwoNumber_002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode ans = dummyHead;

        while(l1 != null || l2 != null){
            int x = (l1 == null)? 0 : l1.val;
            int y = (l2 == null)? 0 : l2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);

            ans = ans.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0)//多进一位
            ans.next = new ListNode(carry);
        return dummyHead.next;
    }
}
//因为linkedlist有1~100个node，如果用一个数表示整个数的话，这个数会很长，不能用int/long之类的数来表示
//所以不能先算出num1，num2再相加，而是过程中就相加