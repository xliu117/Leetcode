# 207. Course Schedule

Medium


There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 

Output: true

Explanation: There are a total of 2 courses to take. 

             To take course 1 you should have finished course 0. So it is possible.
             
Example 2:

Input: 2, [[1,0],[0,1]]

Output: false

Explanation: There are a total of 2 courses to take. 

             To take course 1 you should have finished course 0, and to take course 0 you should
             
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

思路

这题其实就是问的能不能做出一个topological sort出来。也就是问这个图有没有cycle。
LintCode写的DFS过不去因为stackoverflow了。
思路就是先把图给做出来。然后对vertex进行dfs，维护一个叫onStack的数组记录dfs在每一个stack上访问过的v的状态。如果我们发现正在访问的点在stack上的状态是已经访问过，那么说明有一个环又回来到这个点了。那么就有cycle了。
