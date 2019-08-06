//solution1: top-down
public class Solution{
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0 || tirangle[0] == null || tirangle[0].length == 0){
            return 0;
        }
        
        int m = triangle.length;
        int[][] f = new int[m][m];
        
        f[0][0] = triangle[0][0];
        for(int i = 1; i < m; i++){
           f[i][0] = f[i-1][0] + triangle[i][0];
           f[i][i] = f[i-1][i-1] + triangle[i][i];
        }
        
        for(int i = 2; i < m; i++){
            for(int j = 1; j < i; j++){
               f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) +  triangle[i][j];
            }
         }
         
         int min = Integer.MAX_VALUE;
         for(int i = 0; i < m; i++){
             if(min > f[m-1][i]){
                min = f[m-1][i];
             }
         }
         
         return min;
      }
      
  }    
         
         
