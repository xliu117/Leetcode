/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public Node cloneGraph(Node node) {
        // write your code here
        
        if(node == null){
            return node;
        }
        
        //use bfs algorithm to traverse the graph and get all nodes
        ArrayList<Node> nodes = getNodes(node);
        
        //cope nodes, store the old -> new mapping information in a hash map
        HashMap<Node, Node> mapping = new HashMap<>();
        for(Node n : nodes){
            mapping.put(n, new Node(n.val));
        }
        
        
        //copy edges(neighbors)
        for(Node n : nodes){
            Node newNode = mapping.get(n);
            for(Node neighbor : n.neighbors){
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    
    private ArrayList<Node> getNodes(Node node){
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()){
            Node head = queue.poll();
            for(Node neighbor : head.neighbors){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<Node>(set);
        
    }
}
