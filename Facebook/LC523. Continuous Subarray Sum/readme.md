# 523. Continuous Subarray Sum

Medium

 
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.

 

Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.



## Summary

### Thoghts:

Solution1: brute force: 

two for loops for start_index and end_index of a selected array, and then another for loops go though the selected array to calculate the sum. 

time complexity : O(n^3)
space: O(1)

Solution2: accumulate sum:
