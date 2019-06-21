# [LintCode] 618 Search Graph Nodes 解题报告

Description

Given a undirected graph, a node and a target, return the nearest node to given node which value of it is target, return NULL if you can't find.

There is a mapping store the nodes' values in the given parameters.

Notice

It's guaranteed there is only one available solution


Example

2------3 - 5
 \        |     |
   \      |     |
     \    |     |
       \  |     |
         1 -- 4
         
Give a node 1, target is 50

there a hash named values which is [3,4,10,50,50], represent:

Value of node 1 is 3

Value of node 2 is 4

Value of node 3 is 10

Value of node 4 is 50

Value of node 5 is 50

Return node 4


思路

从当前节点开始BFS。比较每一个遍历的点mapping出来的值是不是target。如果是就return。如果不是，把这个点的邻居都加入queue里。注意加的时候先检测一下要加的点有没有被遍历过。
