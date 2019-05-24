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
/***
//hashset
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HasSet<>();
        while(head != null){
            if(nodesSeen.contains(head)){
                return true;
            }else{
                nodesSeen.add(head);
            }
            head = head.next;
        }
            return false;
    }

}*/

//two pointers
//space: O(1)
public class Solution{
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
