# [LintCode] 578 Lowest Common Ancestor III 解题报告

Description

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Return null if LCA does not exist.

Notice

node A or node B may not exist in tree.


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

这题要注意A和B不一定都在子树里。

用一个ResultType来记录A和B是否在子树里存在，以及LCA node。

用分治法。

1：如果A或B在root上，那么LCA就在root上。

2：如果左子树和右子树都有LCA，那么也说明当前LCA在root上。

3：如果只有左边有LCA，那么LCA就在左边。

4：如果只有右边有LCA，那么LCA就在右边。

最后递归结束以后，需要判断是否A和B都存在。
