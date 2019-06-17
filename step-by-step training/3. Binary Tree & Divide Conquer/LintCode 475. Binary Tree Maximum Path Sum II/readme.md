# [LintCode] 475 Binary Tree Maximum Path Sum II 解题报告

Description

Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.



Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)



思路
分治法。
以当前点开始的maxSum，取决于：
1：以当前点的左儿子为开始的maxSum是否大于0
2：以当前点的右儿子为开始的maxSum是否大于0

如果两者都小于0，那么以当前点开始的maxSum就是当前点的值。

