# [LintCode] 378 Convert Binary Search Tree to Doubly Linked List

Description 

Convert a binary search tree to doubly linked list with in-order traversal. 



Example 

Given a binary search tree: 

   4 
  / \ 
 2   5 
/ \ 
1 3 

Return 1<->2<->3<->4<->5 



Thought 

In order is the order of the left and right. 

In the ResultType we store the head and tail of the current inorder doubly linked list. 

We can do it with the ideas of Divide & Conquer. 

Find: 

1: The doubly linked list of the inorder of the left subtree. 

2: The doubly linked list of the inorder of the right subtree. 

3: The root is a single-node doubly linked list with root.val. 

In the left-root-right order, connect the above three doubly linked lists. 
