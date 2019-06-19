# Leetcode 285. Inorder Successor in BST

Medium


Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.

 

Example 1:


Input: root = [2,1,3], p = 1

Output: 2

Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.

Example 2:


Input: root = [5,3,6,2,4,null,null,1], p = 6

Output: null

Explanation: There is no in-order successor of the current node, so the answer is null.
 

Note:

If the given node has no in-order successor in the tree, return null.

It's guaranteed that the values of the tree are unique.

* Challenge

O(h), where h is the height of the BST.



* 思路

中序遍历是左根右的顺序。

在某一点root，如果root.val > p.val，说明p在root的左子树。那么我们可以往左继续找p。

这时root就是候选的successor。

在某一点root，如果root.val < p.val，说明p在root的右子树。那么我们保持现在的候选successor。

总结：只要往左走，就更新successor的候选为当前点。
