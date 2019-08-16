# 67. Add Binary

Easy


Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


## Summary

### Thoughts

1. rememmber to use: a.charAt(i--) - '0' as a smarter way to conver character to integer.

2. don't forget the last step:  "if (carry != 0) sb.append(carry);" should consider the last carry value.

3. it's good that you have the basic idea about how to solve this problem(use carry, reverse stringbuilder), but you should practise more to writhe the clean and simple code.

### Comlexity analysis

Time O(n) go throung string a and b
space O(n)  extra space is used to build tringbuilder
