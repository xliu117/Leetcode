/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/



//step1: inorder tranversal by recursion to connect the original BST
//step2: connect the head and tail to make it circular
//recursion
//inorder 
class Solution {
    Node first = null;
    Node last = null;
    
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        
        helper(root);
        
        
        //connect head and tail
        last.right = first;
        first.left = last;
        return first;
    }
    
    
    private void helper(Node node){
        if(node == null) return;
        
        //left
        helper(node.left);
        
        //node
        if(last != null){
            last.right = node;
            node.left = last;
        }else{//the first leftest node
            first = node;
        }
        last = node;
        
        //right
        helper(node.right);
        
    }
}
