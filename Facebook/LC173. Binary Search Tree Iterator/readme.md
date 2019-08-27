# 173. Binary Search Tree Iterator

Medium
 
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.


### Summary 

#### key words: 

inorder traversal, stack, recursion, iteration.

#### Solution1: flatten the tree in an inorder array.

we know the fact that the inorder traversal result of a binary search tree is sorted in ascending order.

so that we can solve the probelm as follows:

1. do the inorder traversal(recursion) to get the sorted nodes arraylist. innitialize the index = -1.

2. if we call .next(), we get the node = array.get(++index).

3. if the index is less than the array.size(), it hasNext, otherwise, it does not have next node.

Time complexity O(n), it traverse the whole tree to get the array first. each time for .next() and .hasNext() the time is constant O(1).

Space Complexity O(n). we need an array of size n to store the tree nodes.

#### Solution2: Stack

we can use the stack to do the inorder traversal at realtime.

1. initialize an empty stack.

2. build a helper function to get the leftmostnode starting from the root. for any subtree of any root, the leftmost node of the root is the smallest node in the subtree.

3. build .next() function by firstly do stack.push() to get the upmost node. and if the node.right != null, then put the leftmostnode of the node.right to the stack as the next larger node. if the node.right == null, then do not need to do anything since the next larger node is the stack.peek().

notice that for each iteration, we always find the next node who is just the smallest node larger than the node right now on the top of stack.


4. if the stack() is empty, which means there is no larger nodes than the node right now, than there is no next node. 

Time complexity: 

1. .hasNext() takes O(1) constant time to see whether if the stack is empty.

2. .next(): pop the element from stack takes O(1) time. and the helper function _leftmostInorder() takes O(n) time in the worst case, we only call helper when the node.right != null. so the time is much less than N nodes. 

so the average time complexity of .next() is O(1). not for every call, but for average it is O(1).

Space complexity:

O(h), h is the height of the tree. the customized stack at most have h nodes inside the stake.


