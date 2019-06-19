# [LintCode] 474 Lowest Common Ancestor II 解题报告

Description

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.


Example

For the following binary tree:

  4
 / \
3   7
     / \
   5   6
   
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7


思路

A和B往上总会在一个地方相交，这个地方就LCA。

如果A和B不在同一个高度上，我们可以把一个点往上沿着parent指针跳到和另一个相同高度的位置。

两个相同高度的点同时沿着各自的parent往上爬，爬到相交的地方就是LCA了。
