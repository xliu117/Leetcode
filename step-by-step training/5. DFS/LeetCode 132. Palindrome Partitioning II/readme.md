# 132. Palindrome Partitioning II

Hard


Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1

Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.


与 136. 分割回文串 不同, 这道题目不需要求所有方案, 而是求最小次数 -- 最优解问题.

可以看作序列型动态规划问题, 设定 dp[i] 表示原串的前 i 个字符最少分割多少次可以使得到的都是回文子串.

如果 s 前 i 个字符组成的子串本身就是回文串, 则 dp[i] = 0, 否则:

dp[i] = min{dp[j] + 1} (j < i 并且 s[j + 1], s[j + 2], ... , s[i] 是回文串)
如果想要是 O(n^2n 
2
 ) 的时间复杂度 (n 是 s 的长度), 需要事先求出来回文串信息, 在状态转移时可以 O(1) 地知道一段子串是否回文的.
