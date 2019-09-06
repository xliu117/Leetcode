# 98. Validate Binary Search Tree

Medium
 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


### Summary

#### idea

use recursion to check the node.left tree's upperbound is less than node.val and node.right tree's lowerbound is larger than node.val. or the tree is not valide binar search tree.

#### pseudocode

1. consider if node == null return ture;

2. let val = node.val and use val to compare with lower and upper value, if val <= lower or val >= upper, return false.

3. recursion with left tree, val,upper and right tree, lower,val.

#### complexity

//time O(n) traverse each node once
//space O(n) keep the entire tree
