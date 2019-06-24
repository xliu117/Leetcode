# [LintCode] 611 Knight Shortest Path 解题报告

Description

Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
Return -1 if knight can not reached.

Notice

source and destination must be empty.
Knight can not enter the barrier.


Clarification

If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)


Example

[[0,0,0],
 [0,0,0],
 [0,0,0]]
 
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
 
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
 
source = [2, 0] destination = [2, 2] return -1


思路

找最短路径一般都直接上BFS了。没什么特别的思路。硬做。
每个点有8个方向可以走。所以在每一层，要找8个方向，判断一下是否越界，时候已经遍历过。
