/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/***
//1.traverse recursion
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root,res);      
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        traverse(root.left,res);
        traverse(root.right,res);
    }
}


//2.divide and conquer
class Solution{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        
        return result;
    }
}
*/


//3.Iterative
public class Solution{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        
        if(root == null) {
             return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            
            if(node.right != null){
                stack.push(node.right);
            }
            
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
