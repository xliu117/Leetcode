# [LintCode] 453 Flatten Binary Tree to Linked List 解题报告

Description

Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Notice

Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.


Example
              1
               \
     1          2
    / \             \
   2   5    =>    3
  / \   \               \
 3   4   6             4
                             \
                              5
                                \
                                 6


Challenge

Do it in-place without any extra memory.


思路

解法一

最直接的办法是造一颗新的只往右走的树。pre-order遍历输入的树，把一个一个节点都加到新的树的右边去。最后把root接到新的树上。

解法二

把左右子树分别flatten。然后把flatten过的左子树接在root的右边。然后从root往右走到底，把flatten过的右子树接上。

## LeetCode 114. Flatten Binary Tree to Linked List
