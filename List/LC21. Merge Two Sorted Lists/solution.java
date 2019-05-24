
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/***
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<Integer> array = new ArrayList<>();
        while(l1 != null){
            array.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            array.add(l2.val);
            l2 = l2.next;
        }
        
        Collections.sort(array);
        //System.out.print(array);
        
        ListNode res = new ListNode(0);
        ListNode head = res;
        
        for(int i = 0; i < array.size(); i++){
            ListNode node = new ListNode(array.get(i));
            head.next = node;
            head = head.next;
        }
        
        return res.next;
    }
}


//recursion
class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}*/


//iteration
//better: space O(1)
class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2= l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        
        return prehead.next;
    }
}
