/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/***
//my own solution:
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        //Brute force idea
        //each time find the last node and rotate to the head
        //time complexity is O(n*k)
        
        
        //another idea:
        //find the split point to split the list into two
        //L: 1 -> 2 -> 3 -> null
        //L' : 4 -> 5 -> null
        //reverse L' and connect L' with L
        
        //considering the K > size of the list
        //find the size of the list first
        //and then we can get the true rotate number n = k > sie ? k % size : k
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int i = 0;
        int size;
        int rotatenumber;
        
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
            i++;
        }
        
        if(second != null){
            size = 2* i;
        }else{
            size = 2 * i - 1;
        }
        
        if(size < k){
            rotatenumber = k % size;
        }else{
            rotatenumber = k;
        }
        
        
        int m = size - rotatenumber;
        ListNode node = dummy;
        for(int q = 0; q < m; q++){
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = newHead;
        ListNode node2 = dummy2;
        while(node2.next != null){
            node2 = node2.next;
        }
        node2.next = dummy.next;
        return dummy2.next;
    }
}*/


//algorithm
//1.find the old tail and connext it with the head old_tail.next = head to close the ring, compute the length of the list n at the same time;
//2.find the new tail, which is (n - k % n - 1)th node from the head and the new head, which is (n-k % n)th node.
//3.Break the ring new_tail.next = Node and return new_head
class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    // base cases
    if (head == null) return null;
    if (head.next == null) return head;

    // close the linked list into the ring
    ListNode old_tail = head;
    int n;
    for(n = 1; old_tail.next != null; n++){
      old_tail = old_tail.next;}
    old_tail.next = head;

    // find new tail : (n - k % n - 1)th node
    // and new head : (n - k % n)th node
    ListNode new_tail = head;
    for (int i = 0; i < n - k % n - 1; i++){
      new_tail = new_tail.next;}
    ListNode new_head = new_tail.next;

    // break the ring
    new_tail.next = null;    

    return new_head;
  }
}
