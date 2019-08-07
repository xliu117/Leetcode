# 55. Jump Game

Medium

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.



思路

动态规划

初始值f[0]设置为true，表示可达。遍历左右点。当前点是否可达取决于之前所有点中可达的点加上他们能跳到的地方。时间复杂度O(n2)，空间复杂度O(n)。

贪心法

维护一个能达到的最远的值。每经过一个点，比较一下这个点可以到的值和这个最远值，并更新。最后判断最远值是不是超过了最后一个index。时间复杂度O(n)，空间复杂度O(1)。
