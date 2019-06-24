public class Solution{
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            }
     }
     
     
     
     public int zombie(int[][] grid){
         if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
              return 0;
              }
              
         int people = 0;
         
         Queue<Point> queue = new LinkedList<>();
         for(int i = 0; i < grid.length; i++){
             for(int j = 0; j < grid[0].length; j++){
                  if(grid[i][j] == 0){
                        people++;
                   }
                   if(grid[i][j] == 1){
                       queue.offer(new Point(i,j));
                       }
               }
           }
           
           if(people == 0){
               return 0;
               }
           
           int[] directionX = new int[] { -1, 1, 0, 0};
           int[] directionY = new int[] { 0, 0, -1, 1};
           int step = 0;
           
           while(!queue.isEmpty()){
                 int size = queue.size();
                 for(int i = 0; i < size; i++){
                     Point pt = queue.poll();
                     for(int j = 0; j < 4; j++){
                        Point next = new Point(pt.x + directionX[j], pt.y + directionY[j]);
                        if(isValid(grid,next) && grid[next.x][next.y] == 0) {
                               grid[next.x][next.y] = 1;
                               people--;
                               queue.offer(next);
                         }
                     }
                   }
                  step++;
                  if(people == 0){
                      return step;
                  }
            }
            
            return -1;
       }     
       
       
       public boolean isValid(int[][] grid, Point pt){
            return pt.x >= 0 && pt.x < grid.length 
            && pt.y >= 0 && pt.y < grid[0].length
            && grid[pt.x][pt.y] != 2;
        }
        
   }     
                    
     
               
               
               
