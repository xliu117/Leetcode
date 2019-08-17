# [426. Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/)

Medium

 
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:

 


 
We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.

 


 
Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

 ## Summary
 
 ### Thoughts:
 
1. In this problem, we use DFS + recursion to implement the inorder traversal on the binary search tree(left - node - right).

//left
helper(node.left)

//node
the things we do for node

//right
helper(node.right)

2. initialize two nodes: Node fist = null, last = null.

when DFS reachs the left-down node, first = node, last = node. when it's traversing in the tree, update Node last, connect each node in the tree by last.right = node, node.left = last, last = node.

3. when finish the traversal, connect the node last and first to make linked list to a circle

last.right = first;
first.left = last.

### Complexity

time O(n) it traverse all the nodes in the tree one time
space O(1)
 
