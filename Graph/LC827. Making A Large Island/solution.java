/***class Solution {
    public int largestIsland(int[][] grid) {
        
        int M = grid.length;
        int N = grid[0].length;
        if(M == 0 || N == 0) return 0;
        if(M == 1 && N == 1 && grid[0][0] == 1) return 1;
        
        int[][] label = new int[M][N];
        int[] area = new int[M*N];
        int l = 0;
        int a = 0;
        int maxres = 0;
        int[] dr = new int[]{1,-1,0,0};
        int[] dc = new int[]{0,0,1,-1};
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    l++; //label[i][j] = l;
                    a = 0;
                    dfs(grid, i, j, label, l,  area, a);
                    //area[l] = a;
                }
            }
        }
        //for(int i = 0; i< area.length; i++){
        //    System.out.print(area[i]);
       // }
      
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 0){
                   // if(grid[i+1][j] != 2 && grid[i-1][j] !=2 && grid[i][j-1] !=2 && grid[i][j+1] !=2) continue;
                    int countarea = 1;
                    int[] labelneighbor = new int[4];
                    int[] areaneighbor = new int[4];
                    for(int k = 0; k < 4; k++){
                        
                        if(i+dr[k] >= 0 && i + dr[k] < M && j + dc[k] >=0 && j+dc[k] < M && grid[i+dr[k]][j+dc[k]] == 2){
                            labelneighbor[k] = label[i+dr[k]][j+dc[k]];
                            areaneighbor[k] = area[label[i+dr[k]][j+dc[k]]];
                        }

                    }
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for(int q = 0; q < 4; q++){
                        map.put(labelneighbor[q], map.getOrDefault(labelneighbor[q], 0)+areaneighbor[q]);
                    }
                    for(int key : map.keySet()){
                        countarea += map.get(key);
                    }
                    //countarea = 1 + map.getOrDefault(labelneighbor[0],0)+map.getOrDefault(labelneighbor[1],0)+map.getOrDefault(labelneighbor[2],0)+map.getOrDefault(labelneighbor[3],0);
                   // countarea = 1 + Math.max(Math.max(Math.max(map.getOrDefault(labelneighbor[0],0),map.getOrDefault(labelneighbor[1],0) ), map.getOrDefault(labelneighbor[2],0)),map.getOrDefault(labelneighbor[3],0));
                    map.clear();
                    maxres= (maxres < countarea) ? countarea: maxres;
                    
                }
            }
        }
        return maxres;
    }
    

                                         
    
    
    public void dfs(int[][] grid, int x, int y, int[][] label, int l, int[] area, int a){
        if(x < 0 || x >= grid.length || y < 0 || y >=grid[0].length || grid[x][y] != 1) {
            a--;
            return;
        }
        
        grid[x][y] = 2;
        label[x][y] = l;
        a++; area[l] = a;
        //System.out.print(a);
        dfs(grid, x-1, y, label, l,  area, a);
        dfs(grid, x+1, y, label, l, area,a);
        dfs(grid, x, y-1, label, l, area,a);
        dfs(grid, x, y+1, label, l, area,a);
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new int[0][0];
        }
    
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);
            
            int ret = new Solution().largestIsland(grid);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}*/



class Solution{
    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,-1,0,1};
    int[][] grid;
    int N;
    
    public int largestIsland(int[][] grid){
        this.grid = grid;
        N = grid.length;
        
        int index = 2;
        int[] area = new int[N*N +2];
        for(int r = 0; r < N; ++r){
            for(int c = 0; c < N; ++c){
                if(grid[r][c] == 1){
                    area[index] = dfs(r, c, index++);
                }
            }
        }
        
        int ans = 0;
        for(int x : area) {ans  = Math.max(ans,x);}
        for(int r = 0; r < N; ++r){
            for(int c = 0; c < N; ++c){
                if(grid[r][c] == 0){
                    Set<Integer> seen = new HashSet();
                    for(Integer move : neighbors(r,c)){
                        if(grid[move / N][move % N] > 1){
                            seen.add(grid[move/N][move%N]);
                        }
                    }
                    
                    int bns = 1;
                    for(int i : seen) bns += area[i];
                    ans = Math.max(ans,bns);
                }
            }
            
        }
        return ans;
    }
    
    public int dfs(int r, int c, int index){
        int ans = 1;
        grid[r][c] = index;
        for(Integer move : neighbors(r,c)){
            if(grid[move / N][move % N] == 1){
                grid[move/N][move%N] = index;
                ans += dfs(move/N, move % N, index);
            }
        }
        return ans;
    }
    
    
    public List<Integer> neighbors(int r, int c){
        List<Integer> ans = new ArrayList();
        for(int k = 0; k < 4; ++k){
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(0<= nr && nr < N && 0 <= nc && nc < N){
                ans.add(nr*N + nc);
            }
        }
        return ans;
    }
}
