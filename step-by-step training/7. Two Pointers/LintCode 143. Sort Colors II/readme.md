# [LintCode] 143 Sort Colors II 解题报告

Description

Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.


Notice

You are not suppose to use the library's sort function for this problem.
k <= n



Example

Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].



Challenge

A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?





思路

用3-way-partition的方法，每次把比k小的数字放到前面，把比k大的数字放到后面。

然后递归去排比k小的数字和比k大的数字。

时间复杂度是O(nlogk)。
