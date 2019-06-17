public class Solution{
   public List<List<Integer>> binaryTreePathSum(TreeNode root, int target){
         List<List<Integer>> result = new ArrayList<>();
         List<Integer> list = new ArrayList<>();
         
         if(root == null)
              return result;
              
              
         list.add(root.val);
         helper(root,target,result,list,root.val);
         return result;
   }
   
   
   
   public void helper(TreeNode root, int target, List<List<Integer>> result, List<Integer> list, int sum){
                if(root == null) return;
                
                if(root.left == null && root.right == null && sum == target){
                          result.add(new ArrayList<Integer>(list));
                          return;
                 }
                 
                 
                 if(root.left != null){
                 list.add(root.left.val);
                 helper(root.left, target, result, list, sum + root.left.val);
                 list.remove(list.size() - 1);
                 }
                 
                 if(root.right != null){
                  list.add(root.right.val);
                  helper(root.right, target, result, list, sum + root.right.val);
                  list.remove(list.size() - 1);
                  }
     }
 }    
