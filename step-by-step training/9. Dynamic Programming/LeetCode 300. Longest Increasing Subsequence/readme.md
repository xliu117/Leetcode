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

1. The normal DP solution's pseudo code:

   1. consider corner cases, process properly
   
   2. initialize a dp array with length equal to nums' length, and maximum.
   
   3. for(int i = 1; i < nums.length; i++){
        intitialize maxvalue; //for comparing each appended subsequence's length
        for(int j = 0; j < i; j++){
           if (nums[i] > nums[j]){//which means element nums[i] can be appended after nums[j]
                maxvalue = Math.max(maxvalue, dp[j]);
            }
         }
         
         dp[i] = maxvalue + 1;
         maximum = Math.max(maximum, dp[i]); //after each j loop, compare the result to find out the longest subsequence ending at nums[i] 
            
      }
      
    4. return the maximum.
   
## 3.Complexity Analysis:
 Time:
 We can see at the step 3 of the pseudo code, there are two for loops traversing the length of the nums array.
  so the time complexity is O(n^2).
  
 Space:
 we use an new dp array of length n = nums.length, so the space complexity is O(n).
 
 
 ## Possible optimization methods:
 
 
