/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//iterative
//time:O(n) space:O(1)
/***
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null ) return head;
        
 
        ListNode curr = head;
        ListNode prev = null;
        
      
        
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
}*/

//recursive
class Solution{
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
