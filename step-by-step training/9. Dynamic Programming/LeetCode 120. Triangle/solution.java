//solution1: top-down

public class Solution{
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(tirangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        
        
        //state:f[x][y] == minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        //initialize
        f[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            f[i][0] = f[i-1][0] + triangle[i][0];
            f[i][i] = f[i-1][i-1] + triangle[i][i];
        }
        
        //top-down
        for(int i = 1; i < n; i++){
            for(int j = 1; j < i; j++){
                  f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + triangle[i][j];
            }
        }
        
        //answer
        int best = f[n-1][0];
        for(int i = 1; i < n; i++){
            best = Math.min(best, f[n-1][i]);
        }
        return best;
    }
}

//solution2:bottom-up
public class Solution{
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        //initialize
        for(int i = 0; i < n; i++){
            f[n-1][i] = triangle[n-1][i];
        }
        
        //bottom-up
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j <= i; j++){
                f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + triangle[i][j];
            }
        }
        
        //answer
        return f[0][0];
    }
}


//solution3:memorize search
public class Solution{
    private int n;
    private in[][] minSum;
    private in[][] triangle;
    
    private int search(int x, int y){
        if(x >= n){
            return 0;
        }
        
        if(minSum[x][y] != Integer.MAX_VALUE){
            return minSum[x][y];
        }
        
        minSum[x][y] = Math.min(search(x+1,y), search(x+1,y+1)) + triangle[x][y];
        
        return minSum[x][y];
    }
    
    
    public int minimumTotal(int[][] triangle){
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[o] == null || triangle[0].length == 0){
            return -1;
        }
        
        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        return search(0,0);
    }
}


////////////////////////////
//smarter method:


//solution2:bottown-up
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                List<Integer> nextRow = triangle.get(i+1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
 
            }
        }
        
        return triangle.get(0).get(0);
    }
}

         
         
