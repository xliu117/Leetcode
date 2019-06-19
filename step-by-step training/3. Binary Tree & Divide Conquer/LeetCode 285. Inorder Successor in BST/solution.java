/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//idea:inorder traverse the whole tree, save the result in the arraylist, polllast() to check if its value is larger than p.val. 
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         List<Integer> list = new LinkedList<>();
         TreeNode output=null;
         
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null) { 
            output = root;
            return output;
        }
        
        
       TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            if(curr.val > p.val){
                output = curr;
                break;
            }
            curr = curr.right;
        }

        
        
        return output;
    }
}
