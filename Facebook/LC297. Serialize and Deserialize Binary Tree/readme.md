# [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

Hard

 
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]" 

Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


## Summary

#### idea

For this question, we can use BFS to solve it level by level. for serialize, we use a queue to save the nodes we traversed. 

#### algorithm-serialize

1. corner case: if root == null, return "";

2. initialize a queue and stringbuilder:

Queue<TreeNode> q = new LinkedList<>();
StringBuilder res = new StringBuilder();
 
3. do BFS

3.1 q.add(root);

3.2 while(!q.isEmpty()){
    
    TreeNode node = q.poll();
    
    if(node == null){
         res.append("n,");
         continue;
    }
    res.append(node.val + ",");
    q.add(node.left);
    q.add(node.right);
    }
    
3.3 output res.toString();


#### algorithm-deserialize

for deserialize, the first step is to transfer the string to string arrays(split into subsections), and then go throught the string array.

1. corner case: if data=="" return null;

2. initialize a Queue and String array. add transform the string into string array based on the split ",".

   Queue<TreeNode> q = new LinkedList<>();
 
   String[] values = data.split(",");
   
3. turn the string array to the tree structure.

#### complexity

time: O(n) we traverse each node once.

space: O(n) we have to keep the entire tree 
   
