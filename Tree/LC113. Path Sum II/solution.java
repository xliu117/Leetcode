 
 //recursion
 public class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(root, sum, res, path);
            return res;
        }
        
        public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
            if(root==null) return;
            
            path.add(root.val);
            
            if(root.left==null && root.right==null ){
                if(root.val==sum)
                    res.add(new ArrayList<Integer>(path));
                return;
            }
            if(root.left!=null) {
                dfs(root.left,sum-root.val,res,path);
                path.remove(path.size()-1);
            }
            if(root.right!=null) {
                dfs(root.right,sum-root.val,res,path);
                path.remove(path.size()-1);
            }
            
        }
    }
    
/***
//iteration
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            } 
            if(cur.left==null && cur.right==null && SUM==sum) 
                res.add(new ArrayList<Integer>(path));
  
            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;
        
        }
        return res;
    }
}


*/
