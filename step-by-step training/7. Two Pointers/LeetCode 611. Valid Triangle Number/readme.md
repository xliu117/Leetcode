# 611. Valid Triangle Number

Medium

Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:

Input: [2,2,3,4]

Output: 3

Explanation:

Valid combinations are: 

2,3,4 (using the first 2)

2,3,4 (using the second 2)

2,2,3

Note:

The length of the given array won't exceed 1000.

The integers in the given array are in the range of [0, 1000].


思路

三角形两边之和大于第三边。所以对于每一个S[i]，有多少对小于他数字的和大于S[i]？

上面这个问题其实就是Two Sum - Greater than target这题。

我们先把数组排序，然后遍历，并用双指针对每一个遍历到的数字求满足条件的对子数。全部加起来就是答案。
