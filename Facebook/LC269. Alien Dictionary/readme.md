# [269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary/)

Hard

 
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"

Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"

Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".

Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

### Summary

#### idea

this problem can be solved as graph problem, using BFS to do topological sorting find the order.

#### algorithm

1. consider the corner cases.

2. initialize graph and indegreeHashMap.

3. go throught the string array with every two adjacent words. Build the graph and update indegree information once we find the first different characters in two adjacent words.

4. use BFS to do topological sorting.

   4.1 use a queue to save all the nodes with indegree == 0.
   
   4.2 BFS traversal
   
   4.3 check the valid: if(sb.length() != inDegreeMap.size()) there must be cycle, then it is invalid, return "".
   
   4.4 return output string.
   
#### complexity

time O(n)

space O(n)
   
   
