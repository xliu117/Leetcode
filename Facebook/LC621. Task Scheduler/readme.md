# 621. Task Scheduler

Medium
 
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].


### Summary

#### idea

1. we can use an array to store the number of instances of the character. int[] map = new int[26], 26 represents the 26 characters.

2. and then sort the array to let the highest occurance character to be in map[25].

3. use a while loop to loop n times, allocate the characters based on the number of instances (from higher to lower). 

4. once we looped n times, sort the map array and do a new while loop n times again, till map[25]==0, break;

5. return result.

#### complexity

time: O(N)  the number of total iterations is the result time;
space: O(1) , we use an array to save the number of instances of characters, it takes constant space.


