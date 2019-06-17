public class Solution{
   class ResultType{
        TreeNode node;
        int sum;
        int size;
        public ResultType(TreeNode node, int sum, int size){
                 this.node = node;
                 this.sum = sum;
                 this.size = size;
         }
   }
   
   
   private ResultType result = null;
   
   public TreeNode findSubtree(TreeNode root){
        if(root = null){
             return null;
         }
         
         ResultType rootResult = helper(root);
         return result.node;
         
   }
   
   
   public ResultType helper(TreeNode root){
         if(root == null){
               return new ResultType(null, 0, 0);
          }
          
          ResultType leftResult = helper(root.left);
          ResultType rightResult = helper(root.right);
          
          ResultType currResult = new ResultType(
                           root,
                           leftResult.sum + rightResult.sum + roor.val,
                           leftResult.size + rightResult.size + 1);
          
          if(result == null 
             || currResult.sum * result.size > result.sum * currResult.size){
               result = currResult;
               }
               
           return currResult;
           }
           
   }
