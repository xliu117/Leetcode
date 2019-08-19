# 680. Valid Palindrome II

Easy


Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


### Summary

1. the brute force method is delete a char in the string and check if the remaining string is palindrome. 
time complexity is O(n^2)

but here there is a hint that the maximum length of the string is 50000, which means the good solution's time complexity is at least O(nlogn)

2. Greedy

still the normal two pointers checking procedures initialing from i = 0; j = s.length()-1.

if(s.charAt(i) != s.charAt(j)) then we need to check two ways: delete the i index, check (s,i+1,j) or delete the j index, check(s,i,j-1).

time complexity O(n)

space complexity O(1)
