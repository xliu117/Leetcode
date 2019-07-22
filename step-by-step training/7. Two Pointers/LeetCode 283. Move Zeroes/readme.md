# 283. Move Zeroes

Easy


Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]

Output: [1,3,12,0,0]

Note:

You must do this in-place without making a copy of the array.

Minimize the total number of operations.


思路

用两个指针遍历数组。
一个指针指向可以swap的位置，另一个去找不是0的数。
碰到不是0的，就swap。
