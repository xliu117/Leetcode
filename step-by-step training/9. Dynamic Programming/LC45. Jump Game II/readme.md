# [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/)

Hard

 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.

### Summary

#### idea

this problem can be solved as a BFS problem.

for example, [2,3,1,1,4], from nums[0] = 2 (level 0), we can jump 1 step to nums[1] = 3 or jump 2 step to nums[2] = 1 (level 1). then from nums[1] = 3, it can jump 1 step to nums[2] = 1, or jump 2 steps to nums[3] = 1 or jump4 steps to nums[4] = 4. from nums[2] = 1,  it can jump 1 step to nums[3] = 1. and from nums[3] = 1, it can jump 1 step to nums[4] = 4. so  there are total 3 levels, from the root to nums[4] = 4 there takes 2 step to get.

#### algorithm

1. corner cases. if nums.length <= 1 return 0;

2. initialize the curMax = 0 //the furthest index it can go in each level
   initialize level = 0, index i = 0;
   
3. while(i <= curMax){
      int furthest = curMax;//the furthest we can go
      for(;i<=curMax;i++){//go through each index in this level
          furthest = Math.max(furthest, nums[i] + i); update the furthest we can get.
          if(furthest >= nums.length - 1){
               return level+1;
          }
      }
      
      level++; //update to next level
      curMax = furthest; //updata the curMax
   }
   
4.   return -1; //if from all the index before the lastindex we can not get to the last one, return -1.
   
          
#### complexity

time O(n) BFS traversal each element once.

space O(1) only constant space are used.


