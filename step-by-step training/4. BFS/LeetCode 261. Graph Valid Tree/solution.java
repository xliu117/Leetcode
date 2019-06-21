//Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
// According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

//解法一
//BFS
//要检测是否所有点都连通，我们用BFS从0点开始遍历所有连通的节点。如果遍历结束连通节点数正好就是题目给出的节点数n，那么这个图是全部连通的。
//有n个节点的树，edge的数目一定正正好好是n - 1。所以如果edge < n - 1，说明不连通。如果edge > n - 1，说明有环。
class Solution {
    public boolean validTree(int n, int[][] edges){
        //corner cases 
        if(n == 0){
            return false;
        }
        if(edges.length != n-1){
            return false;
        }
    
        //trasfer int[][] edges to adjacent list
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        //queue for BFS
        //hash for check visited nodes
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> hash = new HashSet<Integer>();
        queue.add(0);
        hash.add(0);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                hash.add(node);
                for(int j = 0; j < adjList[node].size(); j++){
                    if(!hash.contains(adjList[node].get(j))){
                        queue.offer(adjList[node].get(j));
                    }
                }
            }
        }
        
        return hash.size() == n;
    }
}
