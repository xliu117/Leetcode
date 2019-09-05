class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int start = 0; start < n; ++start){
            if(color[start] == -1){
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;
                
                while(!stack.empty()){
                    Integer node = stack.pop();
                    for(int neighbor : graph[node]){
                        if(color[neighbor] == -1){
                            stack.push(neighbor);
                            color[neighbor] = color[node] ^ 1;
                        } else if (color[neighbor] == color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
