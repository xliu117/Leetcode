/***
public class Solution{
    Class ResultType{
        DoublyListNode head;
        DoublyListNode tail;
        Public ResultType( DoublyListNode head, DoublyListNode tail){
            this.head = head;
            this.tail = tail;
            }
     }
     
     
     Public DoublyListNode bstToDoublyList(TreeNode root){
          ResultType result = helper(root);
          return result.head;
     }
     
     Public ResultType helper(TreeNode root){
         if(root == null){
             return new ResultType(null,null);
             }
         
         ResultType left = helper(root.left);
         ResultType right = helper(root.right);
         
         ResultType curr = new ResultType(null,null);
         DoublyListNode node = new DoublyListNode(root.val);
         
         if(left.head != null){
             left.tail.next = node;
             node.prev = left.tail;
             curr.head = left.head;
             }
             
         else{
             curr.tail = node;
             }
         
         return curr;
         }
         
         
    }
*//
    
//Iterative in order traversal
    
public class Solution{
    public DoublyListNode bstToDoublyList(TreeNode root){
        if(root == null) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        DoublyListNode head = null;
        DoublyListNode prev = null;
        
        while( cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            DoublyListNode node = new DoublyListNode(cur.val);
            if(head == null){
                head = node;
            }
            
            node.prev = prev;
            if(prev != null){
                prev.next = node;
            }
            cur = cur.right;
            prev = node;
        }
        return head;
    }
}
          
