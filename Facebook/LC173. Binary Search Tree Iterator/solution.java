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


/* Solution2: Stack*/
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
    Stack<TreeNode> stack;
    

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this._leftmostInorder(root);
        
    }
    
    
    private void _leftmostInorder(TreeNode root){
        while(root != null){
            this.stack.push(root);
            root =root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode topmostNode = this.stack.pop();
        
        if(topmostNode.right != null){
            this._leftmostInorder(topmostNode.right);//find the next larger node， it will be always on the top of stack
        }
        
        return topmostNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.stack.size() > 0;//when the stack is empty, there will not be next node
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
