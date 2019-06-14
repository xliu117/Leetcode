/***
//Solution1:
//cosider the whole matrix as a sorted array.
//Time complexity: O(log(m*n))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner cases
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
      
        int rowN = matrix.length;
        int colN = matrix[0].length;
        //corner case2
        if(matrix[0][0] > target || matrix[rowN-1][colN-1] < target) return false;
        
        
        int lo = 0;
        int hi = rowN * colN - 1;
        
        
        while(lo+1 < hi){
            int mi = lo + (hi - lo)/2;
            int idr = mi/colN;
            int idc = mi%colN;
            
            int val = matrix[idr][idc];
            
            if(val == target){
                return true;
            }
            else if(val > target){
                hi = mi;
            }
            else if(val < target){
                lo = mi;
            }
        }
        
        if(matrix[lo/colN][lo%colN] == target) return true;
        if(matrix[hi/colN][hi%colN] == target) return true;
        return false;
    
    }
}*/

//Solution2:
//Use binary search for matrix[i][0] to find the row where target is in, and then use binary search for matrix[row][j] to find target. This solution is better because it avoids multiplication overflow(height*width) and / and % while it's complexity is the same as solution1.
//Time Complexity:O(logm+logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner cases
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
      
        int rowN = matrix.length;
        int colN = matrix[0].length;
        //corner case2
        if(matrix[0][0] > target || matrix[rowN-1][colN-1] < target) return false;
        
        //first to find the row where target are located in:
        int lo = 0;
        int hi = rowN - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(matrix[mid][0] == target) return true;
            else if(target < matrix[mid][0]) hi = mid-1;
            else lo = mid+1;
        }
        if(lo == 0) return false;
        int row_idx = lo - 1;
        lo = 0;
        hi = colN-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(matrix[row_idx][mid] == target) return true;
            else if(target < matrix[row_idx][mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
        
        
        
        
        
     
    }
}

//Actually. the first one is O(log(m * n)) = O(log(m) + log(n)) and the second one is O(log(m) + log(n)). They have the same complexity!!
