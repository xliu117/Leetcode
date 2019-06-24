class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        
        for(int course = 0; course < numCourses; course++){
            adj[course] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            count++;
            int n = adj[v].size();
            for(int i = 0; i < n; i++){
                inDegree[adj[v].get(i)]--;
                if(inDegree[adj[v].get(i)]== 0){
                    queue.offer(adj[v].get(i));
                }
            }
        }
        return count == numCourses;
    }
}
