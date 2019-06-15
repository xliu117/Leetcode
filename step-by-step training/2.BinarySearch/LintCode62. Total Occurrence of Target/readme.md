# [LintCode] 462 Total Occurrence of Target 解题报告

Description

Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.


Example

Given [1, 3, 3, 4, 5] and target = 3, return 2.

Given [2, 2, 3, 4, 6] and target = 4, return 1.

Given [1, 2, 3, 4, 5] and target = 6, return 0.


Challenge

Time complexity in O(logn)

思路

二分法。先找第一个出现的target，再找最后一个出现的target。
