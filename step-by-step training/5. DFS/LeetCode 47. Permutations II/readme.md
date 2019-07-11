# 47. Permutations II

Medium


Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]



思路
还是是套模版。
和Permutation这题不同的是这题需要考虑重复的问题。我们可以参考Subset II去重的思路。
还是先排序。以[1, 21, 22, 23]为例，上标表示重复的这个数字出现的先后。
在把候选数字放入list的时候，我们不允许候选数字已经在list里，也不允许例如23在22还没有有选之前就选择。
判断的方法是维护一个visit的数组来表示某一个元素有没有已经在list里了。
