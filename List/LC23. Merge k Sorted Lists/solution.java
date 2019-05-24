/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/***
//O(nlogk)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val == o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for(ListNode node : lists){
            if(node != null)
                queue.add(node);
        }
        
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            
            if(tail.next != null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
/***
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
*/

//solution2:divide and conquer
//time:O(Nlogk)
//space:O(1)
class Solution{
    public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists, 0, lists.length-1);
    }
    
    public static ListNode partion(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        if(start < end){
            int q = (start + end)/2;
            ListNode l1 = partion(lists, start, q);
            ListNode l2 = partion(lists, q+1, end);
            return merge(l1, l2);
        }else{
            return null;
        }
    }
    
    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null ) return l2;
        if(l2 == null ) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }

    }
}
