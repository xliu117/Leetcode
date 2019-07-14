# 51. N-Queens

Hard

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4

Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


思路：
经典8皇后问题的推广版n皇后问题。两题其实是一回事，I的难度反而更大一些。因为能解I得到所有解，必然能知道一共几个解从而能解II。同样也是类似DFS的backtracking问题。难点在于如何判断当前某一位置是否可以放皇后，需要通过之前所有放置过的皇后位置来判断。对已经放置的任意皇后，需要判断当前位置是否在同一行、列、对角线上这三个条件。
1. 逐行放置皇后：排除在同一行的可能。
2. 记录之前所放皇后的列坐标：col[i]=j表示第i行的皇后在第j列。这样在放置第i+1行时，只要保证col[i+1] != col[k], k=0...i 即可。
3. 对角线判断：对于任意(i1, col[i1])和(i2, col[i2])，只有当abs(i1-i2) = abs(col[i1]-col[i2])时，两皇后才在同一对角线。


【解题思路】

深度遍历+回溯。

1.      从上到下，从左到右，判断某个位置是否可以放皇后，可以放，转2，不可以，转3；

2.      放置皇后，并判断是否已经放置N个皇后，如果是，记录结果并回溯；否则转1，递归判断下一行能否放置皇后；

3.      判断本行下一列是否可以放置皇后。如果本列无法放置皇后，剪枝；否则查看下一列能否放置皇后。
即，可以放置，就往下找；放不了，就往回看，拜托上层变一变，看能不能继续往下找，直到第一层都试过最后一列的位置，程序结束。

由于需要记录所有可行结果并输出，在每次得到可行结果时，将当前结果保存，并将Q还原为"."，方便回溯。 
--------------------- 
作者：Azoobie 
来源：CSDN 
原文：https://blog.csdn.net/sinat_26230689/article/details/52206498 
版权声明：本文为博主原创文章，转载请附上博文链接！
