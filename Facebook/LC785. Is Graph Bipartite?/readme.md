# 785. Is Graph Bipartite?

Medium

 
Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
 

Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].


### Summary

#### Idea

This problem can be solved by BFS, use an array int[] named color to label the color of nodes in the graph. at first color all the node white, then color the first chosen node with red, check its neighbors, if it is white, color it blue, if its color is red, means the graph is not bipartite.

#### algorithm:

1. initialization: int[] color = new int[graph.length]; fill the color array with -1, representing white color.

2. for each node in the graph
       if color[node] == -1 //if the node color is white, push it the the stack
          stack.push(node);
          color[node] = 0; //0 representing red color.
          
3.        while(!stack.empty()){
              Integer newnode = stack.pop();
              for(int neighbor : graph[newnode]){
                 if(color[neighbor] == -1)//if the neighbor color is white, push it to the stack, and color it using a diffrent color as its mother
                    stack.push(neighbor);
                    color[neighbor] = color[node] ^ 1; //a^1 means: if a == 0, a^1 == 1; if a == 1, a^1 ==0.
                 else if(color[neighbor] == color[node]){
                    return false;
          
4.   return true;


#### complexity

time: O(m+n), n is the number of nodes in the graph, m is the number of edges. we traverse each node once and traversing all its edges in the process.

space: O(n), we use an array to store the color of all nodes.


