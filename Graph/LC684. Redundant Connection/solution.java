class Solution {
    /***
     List<Integer> parent = new ArrayList<>();
    
    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        List<Integer> parent = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        //thought:check cycle using parent array
        
        for(int i = 0; i < length; i++){
            int before = parent(edges[i][1]);
            int curr = edges[i][0];
            
            if(parent(before) == 0){
            parent(before) = curr;
            }else{
                
                
                if(findparent(before) == findparent(curr))
                    res = edges[i];
                    return res;
            }
            
        }
    }
    
    
    public int union(int r1, int r2){
        parent[r1] = r2; //arbitary make one's father as another
    }
    
    public int findparent(int vertex){
        int w = vertex;
        while( parent[w] != 0){
            w = parent[w];
        }
        return w;
    }
}*/
    
    
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges){
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for(int[] edge:edges){
            if(!dsu.union(edge[0],edge[1])) return edge;
        }
        throw new AssertionError();
    }
}

class DSU{
    int[] parent;
    int[] rank;
    
    public DSU(int size){
        parent = new int[size];
        for(int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size];
    }
    
    public int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);//recursion
        return parent[x];
    }
    
    public boolean union(int x, int y){
        int xr = find(x), yr = find(y);
        if(xr == yr){
            return false;
        }else if(rank[xr] < rank[yr]){
            parent[xr] = yr;
        }else if (rank[xr] > rank[yr]){
            parent[yr] = xr;
        }else{
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}
