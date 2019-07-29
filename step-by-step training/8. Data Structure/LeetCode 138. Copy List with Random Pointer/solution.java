/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
/***
//solution1:
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        //copy node value 1 -> 1' -> 2 -> 2' -> ... n -> n' -> null
        Node ptr = head;
        while(ptr != null){
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        
        //copy random pointers
        ptr = head;
        while(ptr != null){
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        //split old list and new list
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_old = head.next;
        
        while(ptr_old_list != null){
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
额外空间复杂度O(1)，时间复杂度O(n)
*/


//solution2:
//第一步：使用HashMap，首先复制所有的节点，用HashMap记录老节点A与新节点A'的映射关系。

//第二步：遍历每个点，将Random指针连上。如存在一条Random指针从A指向B，那么在HashMap中找到映射的新节点A'和B'，将A'的Random指针指向B'。

//额外空间复杂度O(n)，时间复杂度O(n)

class Solution{
     HashMap<Node, Node> visited = new HashMap<Node,Node>();
    
    public Node getClonedNode(Node node){
        if(node != null){
            if(this.visited.containsKey(node)){
                return this.visited.get(node);
            }else{
                this.visited.put(node,new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }
    
    
    public Node copyRandomList(Node head){
        if(head == null){
            return null;
        }
        
        Node oldNode = head;
        
        //create new headnode
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);
        
        //iterate on the linked list until all nodes are cloned
        while(oldNode != null){
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);
            
            oldNode = oldNode.next;
            newNode = newNode.next;
            
    
        }
        return this.visited.get(head);
    }
}
