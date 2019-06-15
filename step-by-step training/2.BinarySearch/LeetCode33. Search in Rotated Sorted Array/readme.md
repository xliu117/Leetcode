# 33. Search in Rotated Sorted Array
Medium


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

思路

用二分法，判断target的区间。

如果A[mid] > A[start]并且target在它们之间，往前找。否则往后找。注意后面还是一个Sorted Array！

如果A[mid] < A[end]并且target在它们之间，往后找。否则往前找。注意前面还是一个Sorted Array！
