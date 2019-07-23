#[LintCode] 587 Two Sum - Unique pairs 解题报告

Description

Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.



Example

Given nums = [1,1,2,45,46,46], target = 47

return 2

1 + 46 = 47
2 + 45 = 47



思路

老样子，先排序。

一个从左，一个从右，往当中走。

如果加起来等于target，那么左边往右走到不是左边这个数的地方，右边往左走到不是右边这个数字的地方。

然后接着比。
