/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/***
//recursion
// time : O(n)
//space : worst O(n), best O(logn)
class Solution {
    private int mindepth = Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
     
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        
        if(root.left == null && root.right == null) return 1;
        else if(root.left == null) {
           mindepth = right + 1;
        }
        else if(root.right ==null){
            mindepth = left + 1;
        }
        else{
            mindepth = Math.min(left,right)+1;
        }
        return mindepth ;
    }
}*/

//dfs iteration
//the iade is to visit each leaf with the dfs strategy, while updating the minimum depth when we reach the leaf node
import javafx.util.Pair;
class Solution {
  public int minDepth(TreeNode root) {
    LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    if (root == null) {
      return 0;
    }
    else {
      stack.add(new Pair(root, 1));
    }

    int min_depth = Integer.MAX_VALUE;
    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> current = stack.pollLast();
      root = current.getKey();
      int current_depth = current.getValue();
      if ((root.left == null) && (root.right == null)) {
        min_depth = Math.min(min_depth, current_depth);
      }
      if (root.left != null) {
        stack.add(new Pair(root.left, current_depth + 1));
      }
      if (root.right != null) {
        stack.add(new Pair(root.right, current_depth + 1));
      }
    }
    return min_depth;
  }
}
