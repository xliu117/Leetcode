# Binary Tree Representation

we represent binary tree in BFS order 

For example:

  1
 / \
2   3
the BFS order or the binary tree above is [1, 2, 3], so this tree will be serialized to {1,2,3}.

For:

  1      1
 /   vs   \
2          2
the bfs order of the two trees are the same: [1,2]. In order to distinguish them, we use
{1, 2, #} to represent the first one and {1, #, 2} to represent the second one. # represent for null node. For {1,2,#} we can make it more shorter by ignore the null node in the tail: {1, 2}.

Let's go through with an bigger binary tree:

    1
   / \
  2   3
 / \   \
4   5   6
   / \
  7   8
it will be serialized to {1,2,3,4,5,#,6,#,#,7,8}.

1: the root
2: left child of 1
3: right child of 1
4: left child of 2
5: right child of 2
#: left child of 3
6: right child of 3
#: left child of 4
#: right child of 4
7: left child of 5
8: right child of 5
the left child and right child of 6, 7, 8 are all null, so they can be ignored as they are at the end of the bfs order.
