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
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        //1.put root into the queue
        queue.offer(root);
        
        //2.bfs
        while(!queue.isEmpty()){
            List<Integer> levellist = new ArrayList<>();
            int size = queue.size();
            //for each level
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                levellist.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(levellist);
        }
        
        return result;
    }
}
