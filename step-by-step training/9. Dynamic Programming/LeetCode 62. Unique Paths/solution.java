/***
//my solution
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >=0; j--){
               if(i != m-1 && j != n-1){
                   dp[i][j] = dp[i+1][j] + dp[i][j+1];
               }else if(i == m-1 && j != n-1){
                   dp[i][j] = dp[i][j+1];
               }else if(i != m-1 && j == n-1){
                   dp[i][j] = dp[i+1][j];
               }else{
                   dp[i][j] = 1;
               }
                
            }
        }
        return dp[0][0];
    }
}
*/


public class Solution {
public int uniquePaths(int m, int n) {
    int[][] grid = new int[m][n];
    for(int i = 0; i<m; i++){
        for(int j = 0; j<n; j++){
            if(i==0||j==0)
                grid[i][j] = 1;
            else
                grid[i][j] = grid[i][j-1] + grid[i-1][j];
        }
    }
    return grid[m-1][n-1];
}
}
