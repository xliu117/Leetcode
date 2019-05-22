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
//inorder traversal
//recursion
//time O(N)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k-1);
    }
    
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}*/

//iteration
//time O(H+k) H=longN O(logN + k)
class Solution{
    public int kthSmallest(TreeNode root, int k){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}

//follow up
//what if the BST is modified(insert/delete) often and you need to find the kth smallest frequently? How would you optimize the kthsmallest routine?
//use the same logic as for LRU cache design

