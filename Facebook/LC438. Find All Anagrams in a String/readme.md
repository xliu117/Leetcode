# 438. Find All Anagrams in a String

Medium


Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

## Summary

### Thoughts:

The subquestion is to judge if two strings are anagram, which is [LC242.Valid Anagram.](https://leetcode.com/problems/valid-anagram/).

So the brute force method is let a sliding window go through the string s, for each substring which length equals to p's length, run the subquestion to see if they are valid anagram, if it is true, add the starting index into result list.

### Complexity:

time: O(n)*O(c) n is the length of string s, c is the length of string p.
space :O(1)
