# [LintCode] 31 Partition Array 解题报告

Description

Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left

All elements >= k are moved to the right

Return the partitioning index, i.e the first index i nums[i] >= k.


Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length



Example

If nums = [3,2,2,1] and k=2, a valid answer is 1.



Challenge

Can you partition the array in-place and in O(n)?



思路

标准的3-way-partition。



解题思路

非常相似的题[Partition Array by Odd and Even]

正宗两个指针中对撞型指针的问题

最外层大while循环，终止条件是两根指针对撞

内层循环，分三步走

左边如果小于K, left++

右边如果大于等于K, right--

最后停下时如果left <= right, swap

