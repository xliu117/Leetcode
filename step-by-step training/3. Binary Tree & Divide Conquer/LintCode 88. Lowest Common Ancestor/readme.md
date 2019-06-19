# [LintCode] 88 Lowest Common Ancestor 解题报告

Description

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Notice

Assume two nodes are exist in tree.


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

1 如果A或B就在root上，那么root就是LCA。

2 如果左子树和右子树分别都有LCA，那么root就是LCA。

3 如果右子树没有LCA，左子树有，那么LCA在左子树。

4 如果左子树没有LCA，右子树右，那么LCA在右子树。

5 如果两边都没有，那么就没有。
