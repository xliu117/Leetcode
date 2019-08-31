# [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

Medium

 
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:

In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6



### Summary

#### brute force O(n) time:
use recursion to get intuitive method:


class Solution{
    public int countNodes(TreeNode root){
        return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
    }
}

time complexity O(n), traverse all nodes

space complexity O(h), h is the recursion stack height = O(logn) (binary complete tree)



#### binary search

as it is stated that the tree is complete binary tree.

except for the last level, for the 0-th level, it has 2^0 node, for the i-th level, it has 2^i node.

2^0 + 2^1 + 2^2 + ... +2^i = 2^(i+1) -1;

so the total number of the tree is: number of nodes on the last level + 2^(level) -1;

using binary search, instead of checking the existence of all 2^d possible leafs, one could use binary search and check log(2^d) = d leafs only.
