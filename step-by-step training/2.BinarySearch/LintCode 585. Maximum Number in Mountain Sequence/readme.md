# [LintCode] 585 Maximum Number in Mountain Sequence 解题报告

Description
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.


Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10


思路
二分法。
这个数组是先升序后降序的。所以在任何一点劈开，包含顶点的那一半一定还是一个先升序后降序的数组。
那么每次劈开后我们只要判断这个包含顶点的一半是在左边还是右边，以此来更新start或者end的位置。
最后剩下start和end两个index， 高的那个是mountain top。
