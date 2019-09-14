# 289. Game of Life

Medium

 
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


### Summary

#### idea:

1. corner cases: if board == null || board.length == 0 return;

2. for(int i = 0; i < rows; i++){
       for(int j = 0; j < cols; j++){
            int lives = liveNeighbor(board,i,j);
            
3.           consider the rules:
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

3.1 .     if(lives >=2 && lives <=3 &&(board[i][j]&1) ==1)
             //change the state of board[i][j] from 1 to 3, that is 01 -> 11. which means original state is live, till the end state is live also.
             board[i][j] = 3;

3.2 .     if(lives == 3 && (board[i][j] & 1) == 0)
          // if it self is dead, but it has 3 live neighbors
          //change state from 0 to 2, that is 00 -> 10
          board[i][j] = 2;
          
3.3 do not need to consider other cases.
// such as when itself is live, its liveneighbor < 2 or itself is live, its liveneighbor >3. then it will be dead. 01 -> 01 do not need update.

right now, we have already find all the points next stage. only need to update.

4. move the stage to the right board[i][j] >>= 1; to the final stage.

5.build the private function : private int liveNeighbor(int[][] board, int i, int j) to count the live neighbors.

#### Complexity:

Time complexity is O(rows * cols), 总的 element 数目 
Space complexity is O(1), in-place. 只是操作本 board 而已.
