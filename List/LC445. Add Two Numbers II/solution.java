/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//using stack to get the reverse nodes
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode head = new ListNode(0);
        head = null;
        int sum = 0;
        while(!s1.empty() || !s2.empty() || sum != 0){
            sum += s1.empty() ? 0 : s1.peek();
            sum += s2.empty() ? 0 : s2.peek();
            if(!s1.empty()) s1.pop();
            if(!s2.empty()) s2.pop();
            ListNode n = new ListNode(sum % 10);
            sum /= 10;
            n.next = head;
            head = n;
        }
        return head;
    }
}
