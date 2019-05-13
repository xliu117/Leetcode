/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> sublist = new LinkedList<>();
            
            int levelNum = q.size();
            for(int i = 0; i < levelNum; i++){
                Node curr = q.poll();
                sublist.add(curr.val);
                for(Node c:curr.children){
                    q.offer(c);
                }

            }
            res.add(sublist);

        }
        return res;
    }
}
