/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//top down dfs
//time complexity O(n)
/***
class Solution {
    private int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLength;
    }
    
    private  void dfs(TreeNode p, TreeNode parent, int length){
        if(p == null) return;
        length = (parent != null && p.val == parent.val + 1) ? length + 1: 1;
        maxLength = Math.max(maxLength, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }
}
*/

//Bottom up dfs
class Solution{
    private int maxLength = 0;
    public int longestConsecutive(TreeNode root){
        dfs(root);
        return maxLength;
    }
    
    private int dfs(TreeNode p){
        if(p == null) return 0;
        int L = dfs(p.left) + 1;
        int R = dfs(p.right) + 1;
        if(p.left != null && p.val + 1 != p.left.val){
            L = 1;
        }
        if(p.right != null && p.val + 1 != p.right.val){
            R = 1;
        }
        int length = Math.max(L,R);
        maxLength = Math.max(maxLength, length);
        return length;
    }
}
