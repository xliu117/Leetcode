# 297. Serialize and Deserialize Binary Tree

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


思路
serialize就level order一遍。遇到null就放#，否则就把node.val放上。注意前后有个大括号。
deserialize出来一共有values.length个点。那么我们for循环一遍。拿一个数字出来加到左儿子，拿一个数字出来加到右儿子。碰到#就不用管了。加完记得放进queue里。这个queue是用来level order的。每次拿一个出来，就可以往下加左儿子和右儿子。

