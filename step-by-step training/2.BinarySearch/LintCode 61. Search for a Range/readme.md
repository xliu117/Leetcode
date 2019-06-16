# [LintCode] 61 Search for a Range 解题报告

## Description

Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].


Example

Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


Challenge

O(log n) time.

思路

二分法。
先找到第一个target，再找到最后一个target。

