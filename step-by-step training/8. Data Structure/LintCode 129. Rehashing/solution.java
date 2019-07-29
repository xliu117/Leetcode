class Solution{
     public ListNode[] rehashing(ListNode[] hashTable){
          int capacity = hashTable.length * 2;
          ListNode[] newTable = new ListNode[capacity];
          for(ListNode head : heashTable){
              while(head != null){
                  int newIndex = (capacity + head.val % capacity) % capacity;
                  if(newTable[newIndex] == null){
                      newTable[newIndex] = new ListNode(head.val);
                  }
                  else{
                     ListNode curr = newTable[newIndex];
                     while(curr.next != null){
                         curr = curr.next;
                     }
                     curr.next = new ListNode(head.val);
                  }
                  head = head.next;
              }
           }
           return newTable;
     }
     
 }    
