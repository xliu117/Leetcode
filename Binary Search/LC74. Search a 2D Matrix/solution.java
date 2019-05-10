//1,brute force 
/***
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length ==0) return false;
        int M = matrix.length;
        int N = matrix[0].length;
        int total = M*N;
        for(int k = 0; k < total; k++){
            int m = k / N;
            int n = k % N;
            if( matrix[m][n] == target){
                return true;
            }
        }
        return false;
        
    }
}
*/
//2.Binary search
class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        int M = matrix.length;
        if(M == 0) return false;
        int N = matrix[0].length;
        
        //binary search
        int left = 0, right = M*N - 1;
        int pivotIdx, pivotElement;
        while(left <= right){
            pivotIdx = (left+right)/2;
            pivotElement = matrix[pivotIdx/N][pivotIdx%N];
            if(target == pivotElement) return true;
            else{
                if(target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
