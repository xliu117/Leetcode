//Time complexity : \mathcal{O}(N!)O(N!). There is N possibilities to put the first queen, not more than N (N - 2) to put the second one, not more than N(N - 2)(N - 4) for the third one etc. In total that results in \mathcal{O}(N!)O(N!) time complexity.
//Space complexity : \mathcal{O}(N)O(N) to keep an information about diagonals and rows.

class Solution{
    int rows[];
    int diag1[];
    int diag2[];
    int n;
    List<List<String>> output = new ArrayList();
    int queens[];
    
    public boolean isNotUnderAttack(int row, int col){
        int res = rows[col] + diag1[row+col] + diag2[row - col + n - 1];
        return (res == 0) ? true : false;
    }
    
    public void placeQueen(int row, int col){
        queens[row] = col;
        rows[col] = 1;
        diag1[row+col] = 1;
        diag2[row-col+n-1] = 1;
    }
    
    public void removeQueen(int row, int col){
        queens[row] = 0;
        rows[col] = 0;
        diag1[row+col] = 0;
        diag2[row - col + n - 1] = 0;
    }
    
    public void addSolution(){
        List<String> solution = new ArrayList<String>();
        for(int i = 0; i < n; ++i){
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }
    
    public void backtrack(int row){
        for(int col = 0; col < n; col++){
            if(isNotUnderAttack(row,col)){
                placeQueen(row,col);
                if(row+1 == n) addSolution();
                else backtrack(row + 1);
                removeQueen(row,col);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n){
        this.n = n;
        rows = new int[n];
        diag1 = new int[2*n - 1];
        diag2 = new int[2*n - 1];
        queens = new int[n];
        
        backtrack(0);
        return output;
    }
}


