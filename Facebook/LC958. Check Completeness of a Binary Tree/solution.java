
//BFS

//When level-order traversal in a complete tree, after the last node, all nodes in the queue should be null.
//Otherwise, the tree is not complete.
class Solution{
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }
}
//Time Complexity: O(N), where N is the number of nodes.
//Space Complexity: O(N)
