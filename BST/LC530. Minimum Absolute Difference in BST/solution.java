/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//inorder traversal
class Solution {
    private Integer prev;//初始化null Integer对象
    private int minabsolute;//初始化0
    
    public int getMinimumDifference(TreeNode root) {
        minabsolute = Integer.MAX_VALUE;
        inorder(root);
        return minabsolute;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null){
            minabsolute = Math.min(minabsolute, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}







