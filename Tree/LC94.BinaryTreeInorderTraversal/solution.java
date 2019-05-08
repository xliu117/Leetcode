
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursion
/***
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if (root == null ) return res;//consider corner case []
        
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res){
        if(root != null){
            if(root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if(root.right != null){
                helper(root.right, res);
            }
        }
        
    }
}*/
//iteration
class Solution{
    public List<Integer> inorderTraversal(TreeNode root) {
        List < Integer> res = new ArrayList<>();
        Stack< TreeNode > stack = new Stack<>();
        TreeNode curr = root;
        
        while( curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
