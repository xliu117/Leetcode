/***
//my solution
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
*/


//other solution
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }

        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }

        if(Math.abs(maxDepth(root.left)-maxDepth(root.right)) > 1){
            return false;
        }

        return true;
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
