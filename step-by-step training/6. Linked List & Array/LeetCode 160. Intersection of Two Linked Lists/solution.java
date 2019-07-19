/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode node = headA;
        while(node != null && node.next != null){
            node = node.next;
        }
        ListNode temp = node;
        node.next = headB;
        
        ListNode fast = headA;
        ListNode slow = headA;
        while(fast != null && fast.next != null){
             slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                ListNode node1 = slow;
                ListNode node2 = headA;
                while(node1 != node2){
                    node1 = node1.next;
                    node2 = node2.next;
                }
                temp.next = null;
                return node1;
            }
        }
        temp.next = null;
        return null;
    }
}
