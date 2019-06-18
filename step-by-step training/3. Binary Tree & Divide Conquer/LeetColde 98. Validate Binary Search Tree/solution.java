public class Solution{
     private int lastVal = Integer.MIN_VALUE;
     private boolean firstNode = true;
     
     public boolean isValidBST(TreeNode root){
           if(root == null){
                return true;
                }
                
            if(!isValidBST(root.left)){
                return false;
                }
                
            if(!firstNode && root.val <= lastVal){
                 return false;
                 }
                 
            firstNode = false;
            lastVal = root.val;
            
            if(!isValidBST(root.right)){
                    return false;
                    }
                    
                    
            return true;
     }
}     
           
            
       
