/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//思路
//1 如果A或B就在root上，那么root就是LCA。
//2 如果左子树和右子树分别都有LCA，那么root就是LCA。
//3 如果右子树没有LCA，左子树有，那么LCA在左子树。
//4 如果左子树没有LCA，右子树右，那么LCA在右子树。
//5 如果两边都没有，那么就没有。
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }
}
