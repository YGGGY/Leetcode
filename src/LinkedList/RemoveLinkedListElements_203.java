package LinkedList;

public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)    return null;

        ListNode new_head = head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            if(curr.val == val){
                curr = curr.next;//删掉现在这个
                if(prev != null){//要删的不是head
                    prev.next = curr;
                }
                else{
                    new_head = curr;
                }
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return new_head;
    }


    //------------------------------------------------
    //直接用dummyhead做会更容易一点，不用处理要删除的为head的情况
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) return null;

        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;
        ListNode curr = head;
        ListNode prev = dummy_head;

        while(curr != null){
            if(curr.val == val){
                curr = curr.next;
                prev.next = curr;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy_head.next;
    }
}
