

/***
//solution1: my own thought! stupid!
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

//time O(n) still linear time
***/


/***
//solution2:linear time recursion

class Solution{
    public int countNodes(TreeNode root){
        return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
    }
}

//time O(n)
//space: O(d) = O(logn) to keep the recursion stack, where d is a tree depth
//but this method does not profit from the fact that the tree is a complete one.
*/

//solution3: Binary Search
//use binary search to check nodes existence in the last level
//complexity = O(log(2^d)) = O(d)

