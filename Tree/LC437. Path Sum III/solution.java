//double recursion
//Time complexity: O(n^2)
//Space complexity: O(n)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return numberofPaths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int numberofPaths(TreeNode root, int sum){
        if(root == null) return 0;
        //leftsum = leftsum - root.val;
        return (root.val == sum ? 1 : 0) + numberofPaths(root.left, sum - root.val) + numberofPaths(root.right, sum - root.val);
    }
}
