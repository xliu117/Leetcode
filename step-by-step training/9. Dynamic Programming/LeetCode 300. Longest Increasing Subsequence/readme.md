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
if nums[i+1] > nums[j], then the element nums[i+1] can be appended after nums[j] forming the increasing subsequence.
We need to find out all the possible subsequences and pick the lonest one + 1.
if nums[i+1] is no larger than any elements before it, dp[i+1] = 0 + 1. the longest increasing subsequence start from itself. 


## 2.Algorithm:

1. The normal DP solution's idea:

   1. consider corner cases, process properly
   
   2.initialize a dp array with length equal to nums' length
   
   3.
   
## 3.Complexity Analysis:
