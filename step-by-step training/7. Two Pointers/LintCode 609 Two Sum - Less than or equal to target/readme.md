# [LintCode] 609 Two Sum - Less than or equal to target 解题报告

Description

Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.



Example

Given nums = [2, 7, 11, 15], target = 24.

Return 5.

2 + 7 < 24

2 + 11 < 24

2 + 15 < 24

7 + 11 < 24

7 + 15 < 25




思路

先排序。

左右两个指针，一个往右走，一个往左走。

假设我们发现nums[i] + nums[j] <= target，由于这个数组是排序的，所以nums[i] + i 到 j之间的任何数，一定也是小于等于target的。那么我们就不用重复计算了。
