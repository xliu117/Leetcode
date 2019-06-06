/***
//1.brute force 
//O(mn)
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        
        if(l2 == 0) return 0;
        if(l1 < l2) return -1;

        
        for(int i = 0; i <= l1 - l2; ++i){
           int j = 0;
            while(j < l2 && haystack.charAt(i+j) == needle.charAt(j)) ++j;
            if(j == l2) return i;
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
//O(n)
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
        
        
        
        
