# 314. Binary Tree Vertical Order Traversal

Medium

623

120

Favorite

Share
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]


### Summary:

We solve this problem using BFS

use HashMap<Integer, ArrayList<Integer>> to save the node value for each col.
   
use queue<TreeNode> to do the BFS.

use Queue<Integer> to save the cols value.

use min, max as the boundary of cols.

inside while loop:

  1. each time we poll a treenode, we poll a col correspondingly. if map doesn't containskey(col) add the new coll value to the hashmap.
   
   add the node value to the key col in the hashmap.
   
  2. traverse to node.left and node.right. add node to queue and add (col -1) or (col +1) to queue. update the min, max information.
   
outside while loop:

output the nodes value in each col.

return the result.
