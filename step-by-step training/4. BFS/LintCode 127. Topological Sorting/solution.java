class Solution{
    public ArrayList<Node> topoSort(ArrayList<Node> graph){
         ArrayList<Node> result = new ArrayList<>();
         HashMap<Node, Intger> inDegree = new HashMap<>();
         
         for(Node vertex : graph){
               for(Node neighbor : vertex.neighbors){
                   if(!inDegree.containsKey(neighbor)){
                       inDegree.put(neighbor,1);
                   {
                   else{
                        inDegree.put(neighbor, inDegree.get(neighbor) +1);
                    }
                }
                
           }
           
           
           
           
           Queue<Node> queue = new LinkedList<>();
           for(Node vertex : graph){
                if(!inDegree.containsKey(vertex)){
                    queue.offer(vertex);
                    }
            }
            
            
            
            int count = 0;
            while(!queue.isEmpty()){
                 Node vertex = queue.poll();
                 result.add(vertex);
                 count++;
                 for(Node neighbor : vertex.neighbors){
                      inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                      if(inDegree.get(neighbor) == 0){
                          queue.offer(neighbor);
                          }
                    }
                }
                
                if(count == graph.size()){
                     return result;
                     }
                 return new ArrayList<Node>(0);
                 }
               }  
                    
                    
