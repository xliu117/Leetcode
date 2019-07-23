# [LintCode] 59 3Sum Closest 解题报告

Description

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.


Notice

You may assume that each input would have exactly one solution.



Example

For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).



Challenge

O(n^2) time, O(1) extra space



思路

先排序，然后遍历数组，对于每一个元素，用对撞指针来找有没有和target更近的sum。

注意closestSum初始化不能是Integer.MAX_VALUE。因为如果碰到-1，算abs的时候就越界了。


