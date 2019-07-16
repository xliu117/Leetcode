# 86. Partition List

Medium


Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3

Output: 1->2->2->4->3->5


双指针方法，用两个指针将两个部分分别串起来。最后在将两个部分拼接起来。
left指针用来串起来所有小于x的结点，
right指针用来串起来所有大于等于x的结点。
得到两个链表，一个是小于x的，一个是大于等于x的，做一个拼接即可。
