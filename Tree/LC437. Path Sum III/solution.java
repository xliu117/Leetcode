//Solution1: double recursion
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


//Solution2:Running Prefix sum
//Idea similar to LC560

class Solution{
 public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
