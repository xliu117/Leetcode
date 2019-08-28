# 124. Binary Tree Maximum Path Sum

Hard

 
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

### Summary

#### idea

we could use a recursion function max_gain() to get the maximum gain of the node and one of its subtrees.

the pesudocode:

1. initialize max_sum;

2. build the max_gain() function, 

   if(node == null) return 0;
   
   recursively call max_gain() for the left and right subtrees:
       left_gain = Math.max(max_gain(node.left),0);
       right_gain = Math.max(max_gain(node.right),0);
       
   then check if we start a new path or countinue the old path by computing 
   node.val + left_gain + right_gain
   
   update max_sum if max_sum is smaller.
   
   return node.val + max(left_gain, right_gain);
   
   
#### comlexity

time O(n) we traverse the node less than 2*n

space O(logn) the recursion stack is no more than the hight of the tree. for binary tree, h = logn.
   
   
