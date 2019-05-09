//102. Binary Tree Level Order Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        //List<Integer> temp = new ArrayList<>();
        if(root == null) return levels;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()){
            levels.add(new ArrayList<Integer>());
            
            int level_length = queue.size();
            for(int i=0; i < level_length; ++i){
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}
