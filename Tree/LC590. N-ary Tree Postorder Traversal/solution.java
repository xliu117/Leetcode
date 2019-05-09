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
//recursion
/***
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,res);
        return res;
    }
    
    public List<Integer> helper(Node item, List<Integer> res){
       
        for(Node c : item.children){
            helper(c,res);
        }
        res.add(item.val);
        return res;
    }
}
*/

//iteration
class Solution{
     public List<Integer> postorder(Node root) {
         List<Integer> res = new ArrayList<>();
         Stack<Node> stack = new Stack<>();
         if(root == null) return res;
         stack.push(root);
         while(!stack.isEmpty()){
             Node curr = stack.pop();
             res.add(curr.val);
             for(Node item : curr.children){
                     stack.push(item);
             }
         }
         Collections.reverse(res);
         return res;
}
}


