# 133. Clone Graph

Medium


Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 

Example:



Input:

{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:

Node 1's value is 1, and it has two neighbors: Node 2 and 4.

Node 2's value is 2, and it has two neighbors: Node 1 and 3.

Node 3's value is 3, and it has two neighbors: Node 2 and 4.

Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 

Note:

The number of nodes will be between 1 and 100.

The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.

Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.

You must return the copy of the given node as a reference to the cloned graph.

思路

首先会想到用BFS或者DFS去遍历这个图，然后对于每一个点，我们做一个新的点出来。我们要解决的问题是新做的点之间要像遍历过的点那样连起来。由此我们想到用HashMap来做老的点和新的点之间的对应。
我们用BFS做。具体看代码。
