package LinkedList;

public class DeleteNodeInALinkedList_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

//Since we do not have access to the node before the one we want to delete,
//we cannot modify the "next" of the node before target to point to the node after target.
//Instead, we replace the value of the node with the value of the node after it, and then delete the node after it
