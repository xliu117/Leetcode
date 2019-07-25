# [LintCode] 461 Kth Smallest Numbers in Unsorted Array 解题报告

Description

Find the kth smallest numbers in an unsorted integer array.


Example

Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].


Challenge 

An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.


思路

这题和Kth Largest Element （第K大就是第nums.length - K小）一模一样。

这里第K小个，对应的index就是K - 1。
