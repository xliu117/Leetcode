public class Solution{
   public int  maxPathSum2(TreeNode root){
         if( root == null){
             return 0;
         }
         
         int left = maxPathSum2(root.left);
         int right = maxPathSum2(root.right);
         
         if(Math.max(left,right)<0){
            return root.val;
         }
         
         
         return Math.max(left,right) + root.val;
    }
}    
         
