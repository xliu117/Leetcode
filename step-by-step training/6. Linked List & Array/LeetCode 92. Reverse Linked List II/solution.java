/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //we know that 1 <= m <= n <= length of list
        //find the node before the starting node
       ListNode startnode = new ListNode(0);
        startnode = dummy;
        if(m>1){
        for(int i = 1; i < m; i++){
            startnode = startnode.next;
        }}
        
        
        
        
        int k = n - m + 1;
        
        //reverse the list 
        //startnode-> n1 -> ... nk -> nk+1 -> ...
        //to startnode -> nk -> ... -> n1 -> nk+1 -> ...
        reverseK(startnode, k);
        
        return dummy.next;
    }
    
    
    private void reverseK(ListNode startnode, int k){
        //check there is enough nodes to reverse
       // ListNode next = head;
       // for(int i = 0; i < k; i++){
       //     if(next.next == null){
       //         return;
       //     }
       //     next = next.next;
       // }
        
        //reverse 
        ListNode n1 = startnode.next;
        ListNode prev = startnode, curr = n1;
        for(int i = 0; i < k; i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        n1.next = curr;
        startnode.next = prev;
    }
    
}
