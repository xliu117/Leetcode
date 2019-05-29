class Solution{
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        int h = board.length;
        int w = board[0].length;
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                if(search(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, int d, int x, int y){
        int w = board[0].length;
        int h = board.length;
        if(x < 0 || x == w || y < 0 || y == h || word.charAt(d) != board[y][x])
            return false;
        
        if(d == word.length()-1)
            return true;
        
        char cur = board[y][x];
        board[y][x] = 0;
        boolean found = search(board, word, d+1, x+1, y)||search(board,word,d+1,x-1,y)||search(board,word,d+1,x, y+1)|| search(board,word,d+1,x,y-1);
        board[y][x] = cur;
        return found;
    }
    
}


//Algorithm(DFS):
//0. main():
//1. for y in 1...n
//2.    for x int 1 ... m
//3.       if search(x, y, 0)
//4.           return true;
//5.       else return false;

//0. search(x,y,d):
//1. if out_of_bount(x,y): return flase;
//2. if word[d] != gird[y][x]: return false
//3. if d == word.length - 1: return true;
//4. return search(x-1,y,d+1) || search(x+1, y, d+1) || search(x, y-1, d+1) || search(x, y+1, d+1);

//time complexity:
//search:O(4^l), l = len(word);
//total:O(m*n*4^l)

//space complexity:
//total:O(m*n+l)
