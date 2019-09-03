# [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)

Medium

 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]

Output: 2

Example 2:

Input: [[7,10],[2,4]]

Output: 1

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

### Summary

#### idea: chronological ordering

we treat the start time and end time individually, use two arrays to save the start time and end time respectively. set two pointers: sIdx and eIdx, if sIdx < eIdx, it means no meeting has ended by the time this meeting is to start, we shoulde alllocated a new room. if sIdx > eIdx, it means a meeting has ended so that we can reuse one of the existing rooms.

#### algorithms:

1. use two separate arrays to save the start times and end times individually.

2. sort the start time array and end time array.

3. use two pointers sIdx and eIdx to go through two arrays respectively.

4. if (sIdx >= eIdx) which means there is meeting ends before the start time, we can reuse that room. minRooms--, eIdx++; minRooms++;

5. else if(sIdx < eIdx) which means no meeting has ended by the time this meeting is to start. we need to allocate a new room.minRooms++,sIdx++;

6. repreat until sIdx reached the end of start time array.

#### complexity

time: O(nlogn), 2 sorting operations takes O(2nlogn)

space: O(n) we use extra space of O(2n) 2 arrays to save the start time and end time.
