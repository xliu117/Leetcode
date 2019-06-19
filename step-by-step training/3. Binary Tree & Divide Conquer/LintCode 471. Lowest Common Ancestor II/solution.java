public class Solution{
   public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B){
       if(A==root || B == root){
             return root;
             }
             
             
        int depthA = getDepth(A);
        int depthB = getDepth(B);
        
        if(depthB > depthA){
            ParentTreeNode tmp = B;
            B = A;
            A = tmp;
            }
            
         int diff = Math.abs(depthA - depthB);
         while(diff-- > 0){
            A = A.parent;
            }
            
         while(A != B){
             A = A.parent;
             B = B.parent;
             }
         
         return A;
         
         }
         
         
     public int getDepth(ParentTreeNode node){
         int depth = 0;
         while(node.parent != null){
             depth++;
             node = node.parent;
             }
          return depth;
          
          }
          
    }
