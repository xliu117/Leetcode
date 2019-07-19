/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode first = head, second = head.next;
        
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        ListNode newHead = first.next;
        first.next = null;
        first = newHead.next;
        newHead.next = null;
        
        while(first != null){
            ListNode tmp = first.next;
            first.next = newHead;
            newHead = first;
            first = tmp;
        }
        
        first = head;
        second = newHead;
        
        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
            
        }
    }
}
