# [523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)

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

#### Solution1: brute force: 

For every pair (i,j), check sum of nums[i:j].

Two for loops for start_index and end_index of a selected array, and then another for loops go though the selected array to calculate the sum. 

time complexity : O(n^3)
space: O(1)

#### Solution2: prefix sum:

Precompute the prefix sum in O(n)

prefix_sum[i] = sum(nums[0:i-1]);

For evry pair (i,j) check sum of nums[i:j] in O(1):

sum of nums[i:j] = prefix_sum[j+1] - prefix_sum[i];

time complexity: O(n^2)
space :O(n)

#### Solution3: hashmap

we use a hashmap to save the cumulative sums upto ith index. when the sum is not inside hashmap, add a new entry for it.

our goal is to find that if sum1 = cumulative sum upto ith index, sum2 = cumulative sum upto jth index.

if there is sum1 + n* k = sum2. then we can conclude that the subarray between nums[i+1:j] = n*k. return true.

else return false.

time complexity O(n)

space O(n)
