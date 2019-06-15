# 658. Find K Closest Elements
Medium

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:

Input: [1,2,3,4,5], k=4, x=3

Output: [1,2,3,4]

Example 2:

Input: [1,2,3,4,5], k=4, x=-1

Output: [1,2,3,4]

Note:

The value k is positive and will always be smaller than the length of the sorted array.

Length of the given array is positive and will not exceed 10^4

Absolute value of elements in the array and x will not exceed 10^4


思路：

先用二分法找到数组中>=x的第一个数字，然后向左向右寻找，两个指针向左右移动，直至k次结束，此时将两个指针中间的元素加入结果集即是最终答案。
