# 829. Consecutive Numbers Sum

Hard

 
Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:

Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
Note: 1 <= N <= 10 ^ 9.


### Summary

#### idea1: brute force

the brute force method is to go through each starting number, and scan forward to see if we can meet or exceed the target N.

the time complexity is O(N^2), space complexity is O(1).

#### idea2: math

we can easily get N=(x+1)+(x+2)+⋯+(x+k) then 2∗N=k(2∗x+k+1).

here we use tricks in math, if k is even than the other quantity is odd, and vice versa.

and 2∗x+k+1≥k+1>k.

thus, the answer is the number of ways to factor the odd part of N.

time complexity is O(sqar(n)), space complexity is O(1).
