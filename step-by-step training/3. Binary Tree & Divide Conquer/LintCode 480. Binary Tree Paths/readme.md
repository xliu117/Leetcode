# [LintCode] 480 Binary Tree Paths 解题报告

Description

Given a binary tree, return all root-to-leaf paths.


Example

Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]




思路

DFS。一层一层往下走并且更新path，如果发现已经到leaf了，那么把整个path加到result里去。
