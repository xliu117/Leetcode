class Solution {
    //box size
    int n = 3;
    //row size
    int N = n*n;
    
    int[][] rows = new int[N][N+1];
    int[][] columns = new int[N][N+1];
    int[][] boxes = new int[N][N+1];
    char[][] board;
    boolean sudokuSolved = false;
    
    public boolean couldPlace(int d, int row, int col){
        //check if one could place a number d in (row,col) cell
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }
    
    public void placeNumber(int d, int row, int col){
        //place a number d in (row, col) cell
        int idx = (row / n) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }
    
    public void removeNumber(int d, int row, int col){
        //remove a number which didnot lead to a solution
        int idx = (row / n ) * n + (col / n);
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }
    
    public void placeNextNumbers(int row, int col){
        //call backtrack function in recursion to continue to place numbers till the moment we have a solution
        //if we are in the last cell that means we have the solution
        if((col == N - 1) && (row == N - 1)){
            sudokuSolved = true;
        }
        else{//if we are in the end of the row
            if(col == N - 1) backtrack(row + 1, 0);//go to the next row
            else backtrack(row, col + 1);//go to the next col
        }
    }
    
    
    public void backtrack(int row, int col){
        //if the cell is empty
        if(board[row][col] == '.'){
            //iterate over all numbers from 1 to 9
            for( int d = 1; d < 10 ; d++){
                if(couldPlace(d, row, col)){
                    placeNumber(d,row,col);
                    placeNextNumbers(row,col);
                    if(!sudokuSolved) removeNumber(d,row,col);//?
                }
            }
        }
        else placeNextNumbers(row,col);
    }
    
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        
        //init rows, columns and boxes
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                char num = board[i][j];
                if(num != '.'){
                    int d = Character.getNumericValue(num);
                    placeNumber(d,i,j);

                }

            }

        }
        backtrack(0,0);
    }
}
