# [161. One Edit Distance](https://leetcode.com/problems/one-edit-distance/)

Medium

Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.

### Summary 

Knowing that there can only be one edit distance. so there are some situations:

1. when |length_s - length_t| > 1, it should be false.

we use one pass pointer to go through string s. considering if(s.charAt(i) != t.charAt(i)

2. when length_s == length_t, there must be only one difference of character s.charAt(i) != t.charAt(i). we need to check s.substring(i+1) == t.substring(i+1)

3. when length_s < length_t (or if length_s > length_t, we could swift s and t), there must be only one edit as delete operation. so when s.charAt(i) != t.charAt(i), we need to check the remaining substring s.substring(i) == t.substring(i+1).

4.if we can go through the whole string s and can not find difference. 

return (len_s + 1 == len_t);//if there is no difference on len_s distance, the strings are one edit away only if t has one more character

### complexity

time O(n)

space O(n)
