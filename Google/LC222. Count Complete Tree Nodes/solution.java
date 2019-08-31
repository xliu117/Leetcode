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
    public int countNodes(TreeNode root) {
        //bfs
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            if(size != Math.round(Math.pow(2,level))){
                int total = (int) (Math.pow(2,level) - 1);
                return size + total;
            }
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            level++;
        }
        
        int total = (int)Math.pow(2,level) - 1;
        return total;
    }
}
