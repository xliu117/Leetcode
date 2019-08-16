# LeetCode 354. Russian Doll Envelopes

Hard


You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).


## Summary:

### Thoughts:

This problem is similar to LeetCode 300. Longest Increasing Subsequence. the only tricy thing is how to compare the in[][] arrays. 
We first sort it in a way that put the first element as ascending order, and the second element in the descending order.
Then use the similar dp+binar search algorithm to initialize a array named tails. tails[i] saves the smallest tail of all increasing subsequences with length i+1. Thus, we transfer this problem as the longest increasing subsequence problem

### Complexity Analysis:
We use the binary searh and there is a for loop walking through the whole arraylength, so the time comlexity is O(nlogn).
we use an array tail to save the dp result, so extra space complexity is O(n).

