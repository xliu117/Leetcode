# [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

Medium

 
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000


## Summary

### Solution1: Sorting

#### idea:

we can calculate each point's distance to the origin. and sort them to find the closest k points;

#### algorithm:

1. for loop go through all the points, calculate the distance. O(n).

2. sorting O(nlogn)

3. initialize int[][] ans = new int[K][2]

4. go through all the points again, if the distance points[i] <= distK, add it to the answer. O(n)

5. return the answer.

#### analysis:

time O(nlogn) sorting takes O(nlogn)

space O(n)


