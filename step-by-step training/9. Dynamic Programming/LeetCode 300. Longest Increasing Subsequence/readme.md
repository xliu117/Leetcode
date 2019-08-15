# LeetCode 300. Longest Increasing Subsequence

Medium


Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]

Output: 4 

Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:

There may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

# Summary:

## 1.Idea

1. The normal DP solution's idea:
First initializing a dp array, dp[i] represents the longest increasing subsequence number ending by nums[i].
So in order to get the value of dp[i+1], we need to compare nums[i+1] with the each element j (0 <= j <= i) before it. 
if nums[i+1] > nums[j], then 


## 2.Algorithm:

## 3.Complexity Analysis:
