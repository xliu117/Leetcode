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
//recursion
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root,res);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        traverse(root.left, res);
        traverse(root.right, res);
        res.add(root.val);
    }
}
*/
/***
//解法三： 
//Iterative
//反方向pre-order。然后把答案reverse一下。
class Solution{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        
        stack.push(root);
        
        while( !stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }
        Collections.reverse(res);
        return res;
        
    }
}
*/

public class Solution{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(prev == null || prev.left == node || prev.right == node){
                if(node.left != null){
                    stack.push(node.left);
                }
                else if(node.right != null){
                    stack.push(node.right);
                }
            }
            
            else if(node.left == prev){
                if(node.right != null){
                    stack.push(node.right);
                }
            }
            
            else{
                res.add(node.val);
                stack.pop();
            }
            
            prev = node;
        }
        
        return res;
    }
}
