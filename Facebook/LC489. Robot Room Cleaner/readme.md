# [489. Robot Room Cleaner](https://leetcode.com/problems/robot-room-cleaner/)

Hard


 
Given a robot cleaner in a room modeled as a grid.

Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

Design an algorithm to clean the entire room using only the 4 given APIs shown below.

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
Example:

Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:

The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.


### Summary

#### idea

this problem can be solved by DFS/backtracking. using a hashset to save all the visied cells. if visited.contains(path) return. each time visited a new path, save the path to visited and robot.clean() to clean the cell.

there are 4 different directions to consider. we need to cosider all the situations, if robot.move() is true, then we consider the new location in 4 directions  backtracking(robot, visited, nx, ny, arrow);
then trace back one step:
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
                
 if it can not move forward, always turnRight();
 then update the direction.
 
 #### complexity:
 
 time: O(4^(N-M)) 
 
 space: O(N-M)
 
 N is the total number of cells in the room and M is the total number of obstacle cells.
 
 
 
 这道题就是经典的扫地机器人的题目了，之前经常在地里看到这道题，终于被 LeetCode 收录了进来了，也总算是找到了一个好的归宿了。回归题目，给了我们一个扫地机器人，给了4个 API 函数可供我们调用，具体实现不用我们操心，让我们实现打扫房间 cleanRoom 函数。给的例子中有房间和起始位置的信息，但是代码中却没有，摆明是不想让我们被分心。想想也是，难道我们在给扫地机器人编程时，还必须要知道用户的房间信息么？当然不能够啦，题目中也说了让我们盲目 Blindfolded 一些，所以就盲目的写吧。既然是扫地，那么肯定要记录哪些位置已经扫过了，所以肯定要记录位置信息，由于不知道全局位置，那么只能用相对位置信息了。初始时就是 (0, 0)，然后上下左右加1减1即可。位置信息就放在一个 HashSet 中就可以了，同时为了方便，还可以将二维坐标编码成一个字符串。我们采用递归 DFS 来做，初始化位置为 (0, 0)，然后建一个上下左右的方向数组，使用一个变量 dir 来从中取数。在递归函数中，我们首先对起始位置调用 clean 函数，因为题目中说了起始位置是能到达的，即是为1的地方。然后就要把起始位置加入 visited。然后我们循环四次，因为有四个方向，由于递归函数传进来的 dir 是上一次转到的方向，那么此时我们 dir 加上i，为了防止越界，对4取余，就是我们新的方向了，然后算出新的位置坐标 newX 和 newY。此时先要判断 visited 不含有这个新位置，即新位置没有访问过，还要调用 move 函数来确定新位置是否可以到达，若这两个条件都满足的话，我们就对新位置调用递归函数。注意递归函数调用完成后，我们要回到调用之前的状态，因为这里的 robot 是带了引用号的，是全局通用的，所以要回到之前的状态。回到之前的状态很简单，因为这里的机器人的运作方式是先转到要前进的方向，才能前进。那么我们后退的方法就是，旋转 180 度，前进一步，再转回到原来的方向。同理，我们在按顺序试上->右->下->左的时候，每次机器人要向右转一下，因为 move 函数只能探测前方是否能到达，所以我们必须让机器人转到正确的方向，才能正确的调用 move 函数。如果用过扫地机器人的童鞋应该会有影响，当前方有障碍物的时候，机器人圆盘会先转个方向，然后再继续前进，这里要实现的机制也是类似的
