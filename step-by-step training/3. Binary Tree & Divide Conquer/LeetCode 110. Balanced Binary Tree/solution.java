//divide and conquer
class Solution {
    private int gap = Integer.MIN_VALUE;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int length = depth(root);
        if(gap > 1) return false;
        return true;
     
    }
    
    private int depth(TreeNode root){
        if(root == null) return 0;
        if(root.right == null && root.left == null) return 1;
        int DepthOfLeftSubtree = depth(root.left);
        int DepthOfRightSubtree = depth(root.right);
        gap = Math.max(gap,Math.abs(DepthOfLeftSubtree-DepthOfRightSubtree));
        return  Math.max(DepthOfLeftSubtree,DepthOfRightSubtree)+1;
    }
}
