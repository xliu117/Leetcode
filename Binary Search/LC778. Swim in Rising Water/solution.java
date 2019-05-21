/***class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ((k1,k2) ->
                                                               grid[k1/N][k1%N] - grid[k2/N][k2%N]);
        pq.offer(0);
        int ans = 0;
        
        int[] dr = new int[]{ 1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};
        
        while(!pq.isEmpty()){
            int k = pq.poll();
            int r = k/N, c = k % N;
            ans = Math.max(ans, grid[r][c]);
            if(r == N-1 && c == N-1) return ans;
            
            for(int i = 0; i < 4; ++i){
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if(0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)){
                    pq.offer(ck);
                    seen.add(ck);
                }
            }
        }
        throw null;
    }
}



//2.dfs
class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int N = grid.length;
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(N*N-1)) {
            visited.clear();
            dfs(grid, 0, 0, time, visited);
            time++;
        }
        return time - 1;
    }
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    private void dfs(int[][] grid, int i, int j, int time, Set<Integer> visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] > time || visited.contains(i*grid.length+j)) return;
        visited.add(i*grid.length+j);
        for (int[] dir : dirs) {
            dfs(grid, i+dir[0], j+dir[1], time, visited);
        }
    }
}
*/
//binary search + dfs
class Solution{
    public int swimInWater(int[][] grid){
        int N = grid.length;
        int lo = grid[0][0], hi = N*N;
        while(lo < hi){
            int mi = lo + (hi - lo)/2;
            if(!possible(mi, grid)){
                lo = mi + 1;
            }else{
                hi = mi;
            }
        }
        return lo;
    }
    
    public boolean possible(int T, int[][] grid){
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        seen.add(0);
        int[] dr = new int[]{1, -1, 0,  0};
        int[] dc = new int[]{0, 0, 1, -1};
        
        Stack<Integer> stack = new Stack();
        stack.add(0);
        
        while(!stack.empty()){
            int k = stack.pop();
            int r = k /N, c = k % N;
            if(r == N -1 && c == N - 1) return true;
            
            for(int i = 0; i < 4; ++i){
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if( 0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck) && grid[cr][cc] <= T){
                    stack.add(ck);
                    seen.add(ck);
                }
            }
        }
        return false;
    }
}

