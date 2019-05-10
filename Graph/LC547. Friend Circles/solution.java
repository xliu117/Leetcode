class Solution {
    public int findCircleNum(int[][] M) {
     //dfs
        int N = M.length;
        String[] color = new String[N];
        //int[] color = new int[N];//white = 0; gray = 1; black = 2
        int numc = 0;
        
        for(int i = 0; i < N; i++){
            color[i] = "white";
        }
        
        for(int j = 0; j < N; j++){
            if(color[j] == "white"){
                numc++;
                dfs(M,color, j);
            }

        }
        return numc;
    }
    
    
    public void dfs(int[][] M, String[] color, int v){
        color[v] = "gray";
        for(int w = 0; w< M.length; w++){
            if(M[v][w] == 1 && color[w] == "white"){
                dfs(M, color, w);
            }
        }
        color[v] = "black";
    }
}
        
