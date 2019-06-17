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
class Solution {
    private TreeNode dummy;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        dummy = new TreeNode(0);
        helper(root);
        
        root.val = dummy.right.val;
        root.left = null;
        root.right = dummy.right.right;
        
    }
    
    
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        
        TreeNode curr = dummy;
        while(curr.right != null){
            curr = curr.right;
        }
        
        //pre-order traversal
        
        curr.right = new TreeNode(root.val);
        
        helper(root.left);
        helper(root.right);
    }
}
*/
/***
public class Solution{
    public void flatten(TreeNode root){
        if(root == null){
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);
        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = right;
    }
}
*/

public class Solution{
private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}
}
