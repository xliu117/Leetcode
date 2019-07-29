# [LintCode] 138 Subarray Sum 解题报告

Description

Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.


Notice

There is at least one subarray that it's sum equals to zero.



Example

Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].



思路

看到subarray，会想到和prefixSum有关系。

既然是要求数组中的一段相加为0，我们可以把问题转化成：在数组中找出两个相等的前缀和。
