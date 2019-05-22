
class Solution {
    ArrayList<Integer>[] graph;
    Map<Integer,Integer> color;
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //idea:dfs to color diffrent colors red and blue
        
        //build the graph
        graph = new ArrayList[N+1];
        for(int i = 1; i<=N; ++i)
            graph[i] = new ArrayList();
        
        for(int[] edge:dislikes){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //build the hashmap color <key = node, value = color>
        color = new HashMap();
        for(int node = 1; node <= N; ++node){
            if(!color.containsKey(node) && !dfs(node,0)){
                return false;
            }
        }
        return true;
            
    }
    
    public boolean dfs(int node, int c){
        if(color.containsKey(node)){
            return color.get(node) == c;
        }
        color.put(node, c);
        
        for(int nei:graph[node]){
            if(!dfs(nei, c^1)){ // 1^1 = 0 , 0^1 = 1
                return false;
            }
        }
        return true;
        
    }
}
