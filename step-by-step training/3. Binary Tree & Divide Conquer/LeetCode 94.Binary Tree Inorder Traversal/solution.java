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
//Time complexity : O(n)O(n). The time complexity is O(n)O(n) because the recursive function is T(n) = 2 \cdot T(n/2)+1T(n)=2⋅T(n/2)+1.

//Space complexity : The worst case space required is O(n)O(n), and in the average case it's O(\log n)O(logn) where nn is number of nodes. 

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right,res);
    }
}
*/

//iterative
class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr= curr.right;
        }
        return res;

    }
}
