package Heap;
import java.util.*;

public class MergeKSortedLists_023 {
    //----------------------------------
    //把k个list的第一个node压入heap，取最小的加入ans，然后再把这个的下一个node压入heap，重复
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null)  return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        ListNode dummyHead = new ListNode(0);
        for(ListNode node : lists){
            if(node != null)
                heap.offer(node);
        }

        ListNode curr = dummyHead;
        while(!heap.isEmpty()){
            ListNode next = heap.poll();
            if(next.next != null)
                heap.offer(next.next);
            curr.next = next;
            curr = curr.next;
        }
        return dummyHead.next;
    }
    //Time: O(nlogk)
    //Space: O(k)+O(n)


    //--------------------------------------------
    //分治做法，把lists2个2个合并，结果们再合并直到只剩1个
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    //一直往下拆，直到拆的只剩1个/2个,1个直接返回，2个merge一下，然后把这些结果再merge起来
    private ListNode merge(ListNode[] lists, int left, int right){
        if(left > right)    return null;
        if(left == right)   return lists[left];
        if(left+1 == right) return mergeTwoLists(lists[left], lists[right]);//相邻的两个merge

        int mid = (left+right)/2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid+1, right);
        return mergeTwoLists(l1, l2);//把结果再merge起来
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null)  curr.next = l1;
        if(l2 != null)  curr.next = l2;
        return dummyHead.next;
    }
    //Time: O(nlogk) n是merge时两个linkedlists的长度之和
    //Space:
}


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
