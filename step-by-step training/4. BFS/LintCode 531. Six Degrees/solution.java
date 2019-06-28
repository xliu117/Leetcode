/**
  * Definition for Undirected graph.
  * class UndirectedGraphNode {
  *     int label;
  *     List<UndirectedGraphNode> neighbors;
  *     UndirectedGraphNode(int x) { 
  *         label = x;
  *         neighbors = new ArrayList<UndirectedGraphNode>(); 
  *     }
  * };
  */
  
  public class Solution{
  public int sixDegrees(List<UndirecteddGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t){
       if(graph == null || !graph.contains(s) || !graph.contains(t){
           return -1;
           }
      
        if(s == t){
            return 0;
            }
            
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        int layer = 1;
        q.add(s);
        visited.add(s);
        while(!q.isEmpty()){
             int size = q.size();
             for(int i = 0; i < size; i++){
                  UndirectedGraphNode curr = q.poll();
                  for(UndirectedGraphNode neighbor : curr.neighbors){
                       if(visited.contains(neighbors){
                           continue;
                           }
                       if(neighbor == t){
                          return layer;
                          }
                       else{
                          q.add(neighbor);
                          visited.add(neighbor);
                          }
                   }
             }
             layer++;
        }
        return -1;
    }
 }
 
