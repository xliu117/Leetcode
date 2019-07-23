# 170. Two Sum III - Data structure design

Easy


Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false


思路

Two Sum的一个变形。

还是维护一个HashMap，在add的时候把这个数字的出现过的频率也统计上。

查找value的时候，遍历一下HashMap的keySet，对于每一个key，看看value - key是不是也在keySet里。

注意一下如果key == target的时候我们要看看key的频率是不是大于1。否则就不是答案。
