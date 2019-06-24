# [LintCode] 431 Connected Component in Undirected Graph 解题报告

Description

Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)


Notice

Each connected component should sort by label.


Clarification

Learn more about representation of graphs


Example

Given graph:

A------B  C
  \         |   |
    \       |   |
      \     |   |
        \   |   |
          D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}


思路

看到图的连通的问题都可以想到union find。
这题的UF由于上来不知道点的值的大小，所以不能开一个数组，只能用HashMap来实现。
把所有的点和对应的root存进HashMap。
最后需要输出结果的时候，把相同root的点放进同一个list。最后把每个list排个序。
