
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
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
		
        //1. duplicate each node
        Node node = head;
        while (node != null){
            Node newNode = new Node();
            newNode.val = node.val;
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        
		//2. set random pointer
        node = head;
        while (node != null){
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        
		//3. build new list
        Node newHead = head.next;
        node = newHead;
        while (head != null){
            head.next = head.next.next;
            head = head.next;
            node.next = head == null ? null : head.next; 
            node = node.next;
        }
        return newHead;
    }
}
