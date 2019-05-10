class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        
        //build graph
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        
        int[] toposort = new int[numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src,lst);
            
            indegree[dest] += 1;
        }
        
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int i = 0;
        
        
        while(!queue.isEmpty()){
            int node = queue.remove();
            toposort[i++] = node;
            
            if(adjList.containsKey(node)){
                for(Integer neighbor : adjList.get(node)){
                    indegree[neighbor]--;
                    
                    if(indegree[neighbor] == 0){
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        if(i==numCourses){
            return toposort;
        }
        return new int[0];
    }
}
