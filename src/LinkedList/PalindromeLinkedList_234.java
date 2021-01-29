package LinkedList;
import java.util.*;

public class PalindromeLinkedList_234 {
    //--------------------------
    //最直接的思路，把linkedlist copy到ArrayList上，再通过two pointer来判断是否回文
    public boolean isPalindrome(ListNode head) {
        List<Integer> copy = new ArrayList<>();
        ListNode curr = head;

        //copy LinkedList value to ArrayList
        while(curr != null){
            copy.add(curr.val);
            curr = curr.next;
        }

        int left = 0;
        int right = copy.size()-1;
        while(left < right){
            //Integer要用equals()，用==会把相等的数判为不等，int才可以用==
            if(!copy.get(left).equals(copy.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    //Time: O(n)
    //Space: O(n)


    //---------------------------------
    //用Recursion可以iterate through the nodes in reverse
    //比如下面这个recursion可以反过来print linkedlist
    /*function print_values_in_reverse(ListNode head)
        if head is NOT null
            print_values_in_reverse(head.next)
            print head.val
    */
    //所以用recursion把node反向遍历一遍，在recursion外面正向遍历一遍，从而判断是否回文
    public boolean isPalindrome2(ListNode head) {
        front = head;
        return recursiveCheck(head);
    }

    private ListNode front;

    private boolean recursiveCheck(ListNode curr){
        if(curr != null){
            if(!recursiveCheck(curr.next))  return false;//recursion下去有地方不是回文，返回false
            if(curr.val != front.val)   return false;
            front = front.next;//recursion每调用结束后返回一次，front指针往后走一个，相当于双指针的left
                                //所以这行绝对不能写在调用recursion的前面
        }
        return true;
    }

    //Time: O(n)
    //Space: O(n)


    //----------------------------------
    //先把后半部分的LinkedList反转，然后用2个指针来判断是否为回文，最后把LinkedList还原
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null)    return true;

            ListNode first_half_end = endOfFirstHalf(head);//find the end of first half
            ListNode second_half_start = reverseList(first_half_end.next);//reverse second half;

            //check palindrome
            ListNode p1 = head;
            ListNode p2 = second_half_start;
            boolean result = true;

            while(result && p2 != null){
                if(p1.val != p2.val)
                    result  = false;
                p1 = p1.next;
                p2 = p2.next;
            }

            //restore the Linked list and return
            first_half_end.next = reverseList(second_half_start);
            return result;
        }


        private ListNode endOfFirstHalf(ListNode head){
            ListNode fast = head;
            ListNode slow = head;

            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private ListNode reverseList(ListNode head){
            ListNode prev = null;
            ListNode curr = head;

            while(curr != null){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }


}
