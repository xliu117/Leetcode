public class Solution{
       class ResultType{
                TreeNode node;
                int sum;
                public ResultType(TreeNode node, int sum){
                   this.node = node;
                   this.sum = sum;
                 }
       }
       
       private ResultType result = null;
       
       public TreeNode findSubtree(TreeNode root){
                    if(root == null){
                              return null;
                      }
                      
                      ResultType rootResult = helper(root);
                      return result.node;
                      
        }
        
        
        public ResultType helper(TreeNode root){
              if(root == null){
                     return new ResultType(null, 0);
               }
               
               ResultType leftResult = helper(root.left);
               ResultType rightResult = helper(root.right);
               ResultType currResult = new ResultType(root, leftResult.sum + rightResult.sum + root.val);
               
               if(result == null || currResult.sum < result.sum){
                  result = currResult;
                }
                
                return currResult;
           }
           
  }
