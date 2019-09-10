# 300. Longest Increasing Subsequence

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


### Summary

#### idea

this problem is a classic Dynamic Programming problem. the classic solution is using dp[i] to represent the length of the longest increasing subsequence possible considering the array elements upto the i-th index.


#### key pseudocode

int[] dp = new int[nums.length];

dp[0] = 1;

int maxans = 1;

for(int i = 1; i < nums.length; i++){
    int maxval = 0;
    for(int j = 0; j < i; j++){
        if(nums[i] > nums[j]){
            maxval = Math.max(maxval, dp[j]);
        }
    }
   dp[i] = maxval + 1;
   maxans = Math.max(maxans,dp[i]);
}
return maxans;
   
#### complexity

time O(N^2) two for loops 

space O(n) the int[nums.length] dp array is used.
