
# 28. Implement strStr()

 Easy

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
=
* Example 1:

Input: haystack = "hello", needle = "ll"

Output: 2

* Example 2:

Input: haystack = "aaaaa", needle = "bba"

Output: -1


Clarification:
=

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Solution:
=
* 1.Brute Force

Idea:
scan through string haystack, for each character a, compare if the string needle matches the substring strated at a in haystrack.

Time complexity:
since we need to scan twice(two for-loop), the time complexity is O(n*m).

Space complexity:
O(1)

* 2.KMP
Linear Time

* 3.Rabin-Karp
//O(m+n)
