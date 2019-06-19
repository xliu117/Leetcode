public class Solution{
    class ResultType{
        boolean a_exist, b_exist;
        TreeNode node;
        public ResultType(boolean a_exist, boolean b_exist, TreeNode node){
           this.a_exist = a_exist;
           this.b_exist = b_exist;
           this.node = node;
           }
     }
     
     
     public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B){
             ResultType result = helper(root, A, B);
             if(result.a_exist && result.b_exist){
                 return result.node;
              }
              
              
              return null;
       }
       
       
       public ResultType helper(TreeNode root, TreeNode A, TreeNode B){
              if(root == null){
                  return new ResultType(false, false, null);
                  }
                  
              ResultType left = helper(root.left, A, B);
              ResultType right = helper(root.right, A, B);
              
              boolean a_exist = left.a_exist || right.a_exist || A == root;
              boolean b_exist = left.b_exist || right.b_exist || B == root;
              
              if(A == root || B == root){
                  return new ResultType(a_exist,b_exist,root);
                  }
                  
                if (left.node != null && right.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        
        if (left.node != null) {
            return new ResultType(a_exist, b_exist, left.node);
        }
        
        if (right.node != null) {
            return new ResultType(a_exist, b_exist, right.node);
        }
        
        return new ResultType(a_exist, b_exist, null);
    }
}
           
     
