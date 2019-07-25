# LintCode 144. Interleaving Positive and Negative Numbers

Description

Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.


Example 1

Input : [-1, -2, -3, 4, 5, 6]

Outout : [-1, 5, -2, 4, -3, 6]

Explanation :  any other reasonable answer.


两根指针，首先判断正数多还是负数多，并把多的那一部分移到后半部分，最后两根指针分别递增二交换即可
