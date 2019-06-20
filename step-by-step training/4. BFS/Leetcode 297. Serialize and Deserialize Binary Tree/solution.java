/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null){
                    sb.append("n,");
                    continue;
                }
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "[]"){
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.substring(1,data.length()-1).split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        
        for(int i = 1; i < values.length; i++){
            TreeNode node = queue.poll();
            if(!values[i].equals("n")  ){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                queue.offer(left);
            }
            i++;
            if(!values[i].equals("n")  ){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
