# [LintCode] 376 Binary Tree Path Sum 解题报告

Description

Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.


Example

Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]



思路

DFS + Backtracking
从root往下遍历。如果发现sum == target并且已经走到底了，就把这坨序列加到result里。
