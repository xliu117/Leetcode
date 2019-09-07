# 49. Group Anagrams

Medium

 
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 
### Summary

#### idea

use a hashmap to save the key:String / value:list. there are two ways: solution2:SORT: Two strings are anagrams if and only if their sorted strings are equal. solution2: COUNT: Two strings are anagrams if and only if their character counts (respective number of occurrences of each character) are the same.

#### pseudocode

1. corner case, if strs.length == 0 return[]

2. for loop to go through the strs[] get each str.

3. get the sorted string of str or get the count. turn it to string as the key.

4. check if the key is inside the hashmap, if not, add(key, new ArrayList()) to the hashmap, or  hashmap.get(key).add(s);

5. return new ArrayList(ans.values());


#### complexity:

solution1:sort
//time: O(Nklogk)
//space:O(nk)


solution2: count
//time O(nk)
//space O(nk)
