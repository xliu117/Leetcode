# [953. Verifying an Alien Dictionary](https://leetcode.com/problems/verifying-an-alien-dictionary/)

Easy


In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.


## Summary

## Thoghts:

1. We firstly use a hashmap to store the character and its corresponding order index as key and value. it takes O(26) time.

2. Then use a for loop to go throught the String[] array every two by every two. 

3. compare words[i-1] and words[i].( it's better to write the other private function of isSmaller to compare the two. which makes the code clean)
    if words[i-1] > words[i] return false;
   when finish the whole loop, they all satisfy the relations that words[i-1] < words[i] return true.
   
   //This is the thought of compare adjacent words, if a <= b, and b <= c, then satisfy a <= c.
 
details about comparing two words:

 1. first find the minminum lenth of the two words, put it as our pointer moving boundary.
 
 2. use a pointer i go from index == 0, to the min_len with a while loop
     if map.get(word.charAt(i)) > map.get(word2.charAt(i)) return false;
     if they are equal  i++;
     else return true;
     
     outside the while loop, the i == min_len;
     we only to compare if word1.length > word2.length return false
     else return true.
     
     
## Complexity Analysis

Time complexity O(C) which is the total content of words

Space complexity O(26) = O(1) constant
 
   
    
