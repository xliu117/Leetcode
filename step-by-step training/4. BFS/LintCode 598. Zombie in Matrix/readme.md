# [LintCode] 598 Zombie in Matrix 解题报告

Description

Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.


Example

Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0
return 2


思路

找最少时间，又要用搜索，想到BFS。没什么特别的思路。
先过一遍矩阵，把zombie的位置都丢到queue里，并统计人的数量。
然后开始从这些zombie出发上下左右去把人变成zombile。变一个，人的数量要减1。
如果没有人了。说明搞完了。
如果循环出来人还没死光，说明搞不定了。返回-1。
