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
        if(head == null || head.next == null ) return;
        
        
        
        
        //find the middle node
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode l1 = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        
        //split into two list
        prev.next = null;
        
        
        //reverse second half
        ListNode l2 = reverse(slow);
        
        
        //merge two list
         mergetwolist(l1,l2);
        
         
    }
    
    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;       
        }
        
       return prev;     
    }
    
    
   

    private void mergetwolist(ListNode l1, ListNode l2){
        while (l1 != null) {
        ListNode n1 = l1.next, n2 = l2.next;
        l1.next = l2;
        
        if (n1 == null)
          break;
            
        l2.next = n1;
        l1 = n1;
        l2 = n2;
        }
      }
        
        
        
      
  
}
