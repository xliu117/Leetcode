# [LintCode] 533 Two Sum - Closest to target 解题报告

Description

Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.



Example

Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).



Challenge

Do it in O(nlogn) time complexity.



思路

这个套路的题就是先排序。

排完从两边往当中走。

当我们发现sum < target，说明要再大一点会更接近target。那么往右走。

反之当sum > target，说明要再小一点会更接近target。那么往左走。


