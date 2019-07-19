class Solution{
     public ListNode swapNodes(ListNode head, int v1, int v2){
          if(v1 == v2){
              return head;
              }
          if(head == null || head.next == null){
              return head;
              }
          
          ListNode dummy = new ListNode(-1);
          dummy.next = head;
          ListNode prev1 = dummy;
          ListNode prev2 = dummy;
          
          while(prev1.next != null && prev1.next.val != v1){
              prev1 = prev1.next;
              }
          while(prev2.next != null && prev2.next.val != v2){
              prev2 = prev2.next;
              }
              
          ListNode node1 = prev1.next;
          ListNode node2 = prev2.next;
          
          if(node1 != null && node2 != null){
              prev1.next = node2;
              prev2.next = node1;
              ListNode a2 = node2.next;
              node2.next = node1.next;
              node1.next = a2;
              }
              
           return dummy.next;
           }
       }    
