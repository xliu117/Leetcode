

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

class Solution {
  // Return tree depth in O(d) time.
  public int computeDepth(TreeNode node) {
    int d = 0;
    while (node.left != null) {
      node = node.left;
      ++d;
    }
    return d;
  }

  // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
  // Return True if last level node idx exists. 
  // Binary search with O(d) complexity.
  public boolean exists(int idx, int d, TreeNode node) {
    int left = 0, right = (int)Math.pow(2, d) - 1;
    int pivot;
    for(int i = 0; i < d; ++i) {
      pivot = left + (right - left) / 2;
      if (idx <= pivot) {
        node = node.left;
        right = pivot;
      }
      else {
        node = node.right;
        left = pivot + 1;
      }
    }
    return node != null;
  }

  public int countNodes(TreeNode root) {
    // if the tree is empty
    if (root == null) return 0;

    int d = computeDepth(root);
    // if the tree contains 1 node
    if (d == 0) return 1;

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Perform binary search to check how many nodes exist.
    int left = 1, right = (int)Math.pow(2, d) - 1;
    int pivot;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (exists(pivot, d, root)) left = pivot + 1;
      else right = pivot - 1;
    }

    // The tree contains 2**d - 1 nodes on the first (d - 1) levels
    // and left nodes on the last level.
    return (int)Math.pow(2, d) - 1 + left;
  }
}
