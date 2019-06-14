# [LintCode] 458 Last Position of Target

Description

Find the last position of a target number in a sorted array. Return -1 if target does not exist.


Example Given [1, 2, 2, 4, 5, 5].
For target = 2, return 2.
For target = 5, return 5.
For target = 6, return -1.


思路
二分查找。
注意在nums[mid] == target的时候，说明找到了一个。我们是要找最后一个target，所以要从这个找到的地方开始往后看，看还有没有。所以start = mid。
