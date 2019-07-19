# 143. Reorder List

Medium

Given a singly linked list L: L0→L1→…→Ln-1→Ln,

reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

Idea:
first use two slow and fast pointers find the mid node,
then generate reverse list L' from the second part:
L : L0 -> L1 -> L2 -> L3 -> ... -> Lk
L' : Ln -> Ln-1 -> Ln-2 -> Ln-3 -> ... -> Lk+1
last conbine L and L' together.

