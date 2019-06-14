//do not treat it as a 2D matrix, treat it as a sorted array.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner cases
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int rowN = matrix.length;
        int colN = matrix[0].length;
        
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
}
