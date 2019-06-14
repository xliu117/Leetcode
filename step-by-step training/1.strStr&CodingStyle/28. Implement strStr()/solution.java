/***
28. Implement strStr()
Easy
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

//Brute Force
//idea:
//scan through string haystack, for each character a, compare if the string needle matches the substring strated at a in haystrack.
//time complexity:
//since we need to scan twice(two for-loop), the time complexity is O(n*m).
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        
        //corner case
        if(l2 == 0) return 0;
        if(l1 < l2) return -1;
        
        for(int i = 0; i <= l1-l2; i++){
            for(int j = 0; j < l2; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
                if(haystack.charAt(i+j) == needle.charAt(j) && j == l2-1) return i;
            }
        }
        return -1;
    }
}


//2.Rabin-Karp
//O(m+n)
class Solution {
    public int strStr(String t, String s) {
        if (s.length() > t.length()) return -1;
        final int BASE = 26;
        int tHash = 0, sHash = 0;
        int powerS = 1;

        for (int i = 0; i < s.length(); i++) {
          powerS = i > 0 ? powerS * BASE : 1;
          tHash = tHash * BASE + t.charAt(i);
          sHash = sHash * BASE + s.charAt(i);
        }

        for (int i = s.length(); i < t.length(); i++) {
          if (tHash == sHash && t.substring(i - s.length(), i).equals(s)) {
            return i - s.length();
          }

          tHash -= t.charAt(i - s.length()) * powerS;
          tHash = tHash * BASE + t.charAt(i);

        }

        if (tHash == sHash && t.substring(t.length() - s.length()).equals(s)) {
          return t.length() - s.length();
        }

        return -1;
    }
}  
*/



//3.KMP
class Solution{
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if(l2 == 0) return 0;
        if(l2 > l1) return -1;
        if(l1 == l2 && needle.equals(haystack))  return 0;
        
        int start = 0;
        int i = 0;
        int[] next = getNext(needle);
        while(start <= l1 - l2){
            if(haystack.charAt(start + i) == needle.charAt(i)){
                i++;
                if(i == l2){
                    return start;
                }
            }//return match index
            else{
                start = start + i - next[i];
                i = i > 0 ? next[i] : 0;
            }
        }
        return -1;
    }
    
    
    public int[] getNext(String needle){
        int l2 = needle.length();
        int[] next = new int[l2];
        next[0] = -1;
        if(l2 > 1){
            next[1] = 0;
        }
        int i = 2;
        int j = 0;
        while(i < l2){
            if(needle.charAt(i-1) == needle.charAt(j)){
                next[i] = j+1;
                j++;
                i++;
            }else if(j>0){
                j = next[j];
            }else{
                next[i] = 0;
                i++;
            }
        }
        return next;

    }
}

//Better to understand KMP algorithm

class Solution {
  private int[] computeLPS(String str) { // computes Longest Prefix Suffix (LPS) array
    int[] lps = new int[str.length()];
    lps[0] = 0;
    int i = 1; // always walks forward
    int j = 0; // tracks prefix that matches suffix

    while (i < str.length()) {
      if (str.charAt(i) == str.charAt(j)) {
        j++;
        lps[i] = j;
        i++;
      } else { // mismatch
        if (j == 0) { // go onto next character in string
          lps[i] = 0;
          i++;
        } else { // backtrack j to check previous matching prefix
          j = lps[j - 1];
        }
      }
    }
    return lps;
  }

  int strStr(String haystack, String needle) {
      if (haystack == null || needle == null || haystack.length() < needle.length()) {
          return -1;
      } else if (needle.isEmpty()) {
          return 0;
      }

      int[] lps = computeLPS(needle);
      int i = 0;
      int j = 0;

      while (i < haystack.length()) {
          if (needle.charAt(j) == haystack.charAt(i)) {
              i++;
              j++;
              if (j == needle.length()) {
                  return i - j; // match found. Return location of match
              }
          } else {
              if (j == 0) {
                  i++;
              } else {
                  j = lps[j - 1]; // backtrack j to check previous matching prefix
              }
          }
      }

      return -1; // did not find needle
  }
}
