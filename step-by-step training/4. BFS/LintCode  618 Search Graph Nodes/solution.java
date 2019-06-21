class Solution{
   public Node searchNode(ArrayList<Node> graph, Map<Node,Integer> values, Node node, int target){
       if(node == null){
            return node;
        }
        
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        HashSet<Node> hash = new HashSet<>();
        hash.add(node);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                 Node currNode = queue.poll();
                 if(values.get(currNode) == target){
                     return currNode;
                 }
                 
                 else{
                     for(Node neighbor : currNode.neighbors){
                         if(!hash.contains(nei)){
                              queue.offer(nei);
                              hash.add(nei);
                              }
                     }
                }
             }
         }
         return null;
   } 
}   
            
            
            
