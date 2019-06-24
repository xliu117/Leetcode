# 444. Sequence Reconstruction

Medium


Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example 1:

Input:
org: [1,2,3], seqs: [[1,2],[1,3]]

Output:
false

Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
Example 2:

Input:
org: [1,2,3], seqs: [[1,2]]

Output:
false

Explanation:
The reconstructed sequence can only be [1,2].
Example 3:

Input:
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

Output:
true

Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input:
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

Output:
true
UPDATE (2017/1/8):
The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings). Please reload the code definition to get the latest changes.


这道题给了我们一个序列org，又给我们了一些子序列seqs，问这些子序列能否唯一的重建出原序列。能唯一重建的意思就是任意两个数字的顺序必须是一致的，不能说在一个子序列中1在4的后面，但是在另一个子序列中1在4的前面，这样就不是唯一的了。还有一点就是，子序列seqs中不能出现其他的数字，就是说必须都是原序列中的数字。那么我们可以用了一个一维数组pos来记录org中每个数字对应的位置，然后用一个flags数字来标记当前数字和其前面一个数字是否和org中的顺序一致，用cnt来标记还需要验证顺序的数字的个数，初始化cnt为n-1，因为n个数字只需要验证n-1对顺序即可，然后我们先遍历一遍org，将每个数字的位置信息存入pos中，然后再遍历子序列中的每一个数字，还是要先判断数字是否越界，然后我们取出当前数字cur，和其前一位置上的数字pre，如果在org中，pre在cur之后，那么直接返回false。否则我们看如果cur的顺序没被验证过，而且pre是在cur的前一个，那么标记cur已验证，且cnt自减1，最后如果cnt为0了，说明所有顺序被成功验证了，
