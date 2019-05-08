/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/***
//recursion
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        return helper(root, res);
    }
    
    public List<Integer> helper(Node root, List<Integer> res){
        res.add(root.val);
        for(Node curr : root.children){
            helper(curr, res);
        }
        return res;
    }
}
*/

//iteration
class Solution{
     public List<Integer> preorder(Node root){
         //LinkedList<Node> stack = new LinkedList<>();
         //LinkedList<Integer> res = new LinkedList<>();
         
         List<Integer> res = new ArrayList<>();
         Stack<Node> stack = new Stack<>();
         if(root == null) return res;
         
         stack.push(root);
         while(!stack.isEmpty()){
             Node node = stack.pop();
             res.add(node.val);
             Collections.reverse(node.children);
             for(Node curr : node.children){
                 stack.push(curr);
             }
         }
         return res;
         
     }    
}
