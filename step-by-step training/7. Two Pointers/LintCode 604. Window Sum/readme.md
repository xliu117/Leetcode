# [LintCode] 604 Window Sum 解题报告

Description

Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.


Example
For array [1,2,7,8,5], moving window size k = 3.
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]


思路
先看例子，如果我们要返回一个sums的数组，那么这个数组应该是这样的
sums[0] 1 + 2 + 7                  = nums[0] + nums[1] + nums[2]   （加k次，也就是第一个window）
sums[1] 1 + 2 + 7 - 1 + 8       = sums[0] - nums[0] + nums[0 + 3] （第二个window）
sums[2] 2 + 7 + 8 - 2 + 5       = sums[1] - nums[1] + nums[1 + 3] （第三个window）
