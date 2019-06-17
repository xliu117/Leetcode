public class Solution{
    public List<String> binaryTreePath(TreeNode root){
         List<String> result = new ArrayList<>();
         if(root == null){
                return result;
         }
         
         helper(result, "" + root.val, root);
         
         return result;
     }
     
     
     
     public void helper(List<String> result, String path, TreeNode root){
          if(root.left == null && root.right == null){
               result.add(path);
               return ;
          }
          
          if(root.left != null){
              helper(result, path + "->" + root.left.val, root.left);
              
          }
          
          if(root.right != null){
              helper(result, path + "->" + root.right.val, root.right);
          }
     }
}     
