/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */




class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();//use hashset to store the visited cells.
        backtracking(robot, visited, 0, 0, 0);
    }
    
    
    int[][] dir = {{1,0},{0,1}, {-1, 0}, {0, -1}};//directions
    
    private void backtracking(Robot robot, Set<String> visited, int x, int y, int arrow){
        String path = x + "-" + y;
        
        if(visited.contains(path)) return;
        
        visited.add(path);//add the current cell path to hashset
        robot.clean();//clean the current cell
        
        for(int i = 0; i < 4; i++){
            if(robot.move()){//if robot can move forward and robot moves into the cell
                //go all the way till cannot move, then back one step
                int nx = x + dir[arrow][0];
                int ny = y + dir[arrow][1];
                
                backtracking(robot, visited, nx, ny, arrow);
                  //trace back one step
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            
            robot.turnRight();
            arrow = (arrow+1)%4;
        }
        
    }
   
}

 
