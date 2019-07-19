/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //corner case
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){//there is cycle
                ListNode node = slow;
                ListNode node2 = head;
                 
                while(node != node2){
                    node = node.next;
                    node2 = node2.next;
                     
                }
               
                return node;
            }
            
        }
        return null;
        
    }
}
