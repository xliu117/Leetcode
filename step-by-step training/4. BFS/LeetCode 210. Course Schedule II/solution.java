class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            result[count++] = v;
            for(int w : adjList[v]){
                inDegree[w]--;
                if(inDegree[w] == 0){
                    queue.offer(w);
                }
            }

        }
        
        
        if(numCourses == count){
            return result;
        }
        
        return new int[0];
    }
}
