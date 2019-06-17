# [LintCode] 597 Subtree with Maximum Average 解题报告

Description

Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

Notice

LintCode will print the subtree which root is your return node.

It's guaranteed that there is only one subtree with maximum average.


Example

Given a binary tree:

     1
    /   \
 -5     11
 / \     /  \
1   2 4    -2

return the node 11.

思路

这一类的题目都可以这样做：
开一个ResultType的变量result，来储存拥有最大average的那个node的信息。
然后用分治法来遍历整棵树。
一个小弟找左子数的average，一个小弟找右子树的average。然后通过这两个来计算当前树的average。同时，我们根据算出来的当前树的average决定要不要更新result。
当遍历完整棵树的时候，result里记录的就是拥有最大average的子树的信息。

