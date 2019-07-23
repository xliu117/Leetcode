# 15. 3Sum

Medium


Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

思路

先排序，然后遍历数组，对于每一个元素，求这个数负值的twoSum。

要注意数组重复的数的处理。
