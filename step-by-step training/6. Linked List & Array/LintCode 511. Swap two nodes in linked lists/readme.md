[LintCode] Swap Two Nodes in Linked List 交换链表中的两个结点
 

Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, do nothing.

Notice

You should swap the two nodes with values v1 and v2. Do not directly swap the values of the two nodes.

Example
Given 1->2->3->4->null and v1 = 2, v2 = 4.

Return 1->4->3->2->null.

 

LeetCode上有一道类似的题目Swap Nodes in Pairs，但是又不太一样。这道题其实难度适中，但是需要注意的地方不少。首先需要交换的两个结点有可能是相邻的两个结点，而且有可能v1在v2后面，也有可能首结点就需要交换，那么我们还是一如既往的先设一个dummy结点，后面连上首结点，我们的思路是遍历整个链表，如果cur的下一个结点存在，且等于v1或v2中的一个，此时如果p1为空，说明这是要交换的第一个结点，我们将p1指向这个结点，然后讲pre指向cur，交换操作需要记录要交换的结点的前一个位置，然后继续遍历，当又遇到一个和v1或v2相等的结点，此时我们就需要交换了，我们用p2指向这个结点，然后用临时变量t指向下一个结点，此时我们需要判断cur和p1是相等，相等的话说明p1和p2是相邻的，我们只需要把p2移到p1前面去，如果不相等，说明p1和p2之间还有元素，那么我们交换p1和p2的位置即可，最后返回dummy->next即可：
