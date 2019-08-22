# [143. Reorder List](https://leetcode.com/problems/reorder-list/)

Medium

 
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


## Summary

We can take three sub-steps to solve this problem:

1: find the middle position of the whole list( use two pointers fast and slow);

ListNode prev = null, slow = head, fast = head, l1 = head;

while(fast != null  && fast.next != null){

prev = slow;

slow = slow.next;

fast = fast.next.next;

}

1-1: split the list into two l1 and l2:

prev.next = null;

ListNode l2 = slow.

2: reverse the seconde half list( do the reverse list);

the sub problem is:

[LC202.Reverse Linked list](https://leetcode.com/problems/reverse-linked-list/)

inside a while loop:

while(curr != null){
use two pointers prev and curr, and a new tempnode = curr.next.

curr.next = prev;

prev = curr;

curr = temp;
}

l2 = prev;


3: merge the two lists together.

initialize two n1 and n2 listnode.

n1 = l1.next;
n2 = l2.next;

l1.next = l2;

l2.next = n1;


### complexity

time O(n)

space O(1) inplace operation
