# Search in a Big Sorted Array
## 题目：

Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
Return -1, if the number doesn't exist in the array.

## 分析：

这题目其实主要考察个如何“倍增”，二分法的内容其实没啥区别。
首先可以确定的是，倍增到-1为止或者倍增到大于target，接下来用二分法找first element。需要注意一点，如果get(mid) == -1的话说明mid已经超出范围了，需要让end = mid；


## Leetcode 702
