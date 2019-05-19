/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max_sum = 0;
    
    public int maxPath(TreeNode node){
        if(node == null) return 0;
        
        int left_path = maxPath(node.left);
        int right_path = maxPath(node.right);
        
        int total_path = 1+ left_path + right_path;
        
        max_sum = Math.max(max_sum, total_path);
        
        return 1 + Math.max(left_path, right_path);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxPath(root);
        return max_sum-1;
    }
}
