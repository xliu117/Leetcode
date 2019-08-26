/* Solution1: flatten the tree to inorder array */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator(TreeNode root) {
        this.nodesSorted = new ArrayList<Integer>();
        this.index = -1;
        this._inorder(root);
    }
    
    
    private void _inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }
    /** @return the next smallest number */
    public int next() {
        return this.nodesSorted.get(++this.index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index+1<this.nodesSorted.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
