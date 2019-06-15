# 162. Find Peak Element
Medium

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.


Challenge
Time complexity O(logN)

思路
这道题的题意告诉我们，一定有peak。因为一开始是升序的，最后是降序的。
那么我们在任何一点进行判断，如果这个点的值比左边大，那边这个点右边一定有peak。反之，这个点左边一定有peak。
我们用二分法来做。
