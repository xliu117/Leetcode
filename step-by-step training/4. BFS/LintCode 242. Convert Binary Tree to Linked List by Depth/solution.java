//二叉树的层次遍历，每层的数据用链表存储

public class Solution{
  public List<ListNode> binaryTreeToLists(TreeNode root){
    List<ListNode> result = new ArrayList<>();
    if(root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while(!queue.isEmpty()){
      ListNode head = null;
      ListNode pointer = null; //
      int size = queue.size();
      
      for(int i = 0; i < size; i++){
        TreeNode node = queue.poll();
        if(i == 0){
          head = new ListNode(node.val);
          pointer = head;
        }
        else{
          pointer.next = new ListNode(node.val);
          pointer = pointer.next;
        }
        
        if(node.left != null){
          queue.offer(node.left);
        }
        if(node.right != null){
          queue.offer(node.right);
        }
      }
      result.add(head);
    }
    return result;
  }
}
