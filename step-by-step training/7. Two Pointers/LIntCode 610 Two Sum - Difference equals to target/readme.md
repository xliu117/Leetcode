# [LintCode] 610 Two Sum - Difference equals to target 解题报告

Description

Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.


Notice

It's guaranteed there is only one available solution




Example

Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)




思路
排序以后两个指针同时从左往右走。
