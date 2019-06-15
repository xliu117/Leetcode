# [LintCode] 159 Find Minimum in Rotated Sorted Array 解题报告

## Description
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.


Notice
You may assume no duplicate exists in the array.



Example
Given [4, 5, 6, 7, 0, 1, 2] return 0



## 思路
数组里最小的值一定比数组最后那个数字target = nums[nums.length - 1]的值小，或者相等。
那么我们只要找数组里第一个小于等于target的值。
