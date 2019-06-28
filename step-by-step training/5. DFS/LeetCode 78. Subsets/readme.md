# 78. Subsets

Medium


Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]

Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


使用组合类搜索的专用深度优先搜索算法。

一层一层的决策每个数要不要放到最后的集合里。

思路

这题套用DFS backtrack的模版。搜索的时候，每层递归开始前把当前遍历到的数字放入subset。递归结束后，这个数字作为备选的所有选择都已经找到了，所以我们要把这个数字从subset里去掉。这样，下一个数字又可以放进来进行搜索了。
