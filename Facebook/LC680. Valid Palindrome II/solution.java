

 
//greedy
class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() == 1 || s.length() == 2){
            return true;
        }
        int count = 1;
        int start = 0, tail = s.length() - 1;
        while(start <= tail){
            if(s.charAt(start) != s.charAt(tail)){
               return isPalindrome(s,start+1,tail) || isPalindrome(s,start,tail-1);
            }
            start++;
            tail--;
        }
         return true;
    }
    
   public boolean isPalindrome(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    
}
