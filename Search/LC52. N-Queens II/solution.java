class Solution {
    public boolean is_not_under_attack(int row, int col, int n, int[] rows, int[] diag1, int[] diag2){
        int res = rows[col] + diag1[row + col] + diag2[row - col + n - 1];
        return (res == 0) ? true : false;
    }
    
    public int backtrack(int row, int count, int n , int[] rows, int[] diag1, int[] diag2){
        for(int col = 0; col < n; col++){
            if(is_not_under_attack(row,col,n,rows,diag1,diag2)){
                //place queen
                rows[col] = 1;
                diag1[row+col] = 1;
                diag2[row - col + n -1] = 1;
                
                if(row+1==n) count++;
                else count = backtrack(row+1, count,n, rows, diag1, diag2);
                
                //remove queen
                rows[col]= 0;
                diag1[row+col] = 0;
                diag2[row-col + n - 1] = 0;

            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        int rows[] = new int[n];
        int diag1[] = new int[2*n-1];
        int diag2[] = new int[2*n-1];
        return backtrack(0,0,n,rows, diag1, diag2);
    }
}
