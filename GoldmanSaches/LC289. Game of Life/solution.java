class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = liveNeighbor(board, i, j);
                
                if(lives >= 2 && lives <= 3 && (board[i][j] & 1) == 1){
                    board[i][j] = 3;
                }
                
                if(lives == 3 && (board[i][j] & 1) == 0){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n;j++){
                board[i][j] >>= 1;
            }
        }
        
    }
    
    private int liveNeighbor(int[][] board, int i, int j){
        int lives = 0;
        
        for(int m = Math.max(i-1,0); m <= Math.min(i+1, board.length - 1); m++){
            for(int n = Math.max(j-1, 0); n <= Math.min(j+1, board[0].length-1);n++){
                lives += board[m][n] & 1;
            }
        }
        
        lives -= board[i][j] & 1;
        
        return lives;
        

    
    }
}
