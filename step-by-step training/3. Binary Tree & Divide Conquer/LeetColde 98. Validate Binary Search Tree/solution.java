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
//time: O(n) visit every node once
//space:O(n) keep the entire tree
class Solution {
    public boolean helper(TreeNode node, Integer lower, Integer upper){
        if(node == null) return true;
        int val = node.val;
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;
        
        if(!helper(node.right,val,upper)) return false;
        if(!helper(node.left, lower, val)) return false;
        
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
}
*/

//iteration
//stack + dfs
class Solution{
    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(), lowers = new LinkedList();
    
    public void update(TreeNode root, Integer lower, Integer upper){
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }
    
    
    public boolean isValidBST(TreeNode root){
        Integer lower = null, upper = null, val;
        update(root,lower,upper);
        
        while(!stack.isEmpty()){
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();
            
            if(root == null) continue;
            val = root.val;
            if(lower != null && val <= lower) return false;
            if(upper != null && val >= upper) return false;
            
            update(root.right, val, upper);
            update(root.left, lower, val);
            
        }
        return true;
    }
}
