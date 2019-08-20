class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        
        if(len_s > len_t){
            return isOneEditDistance(t, s);
        }
        
        if(len_t - len_s >1 ){
            return false;
        }
        
        
       for(int i = 0; i < len_s; i++){
           if(s.charAt(i) != t.charAt(i)){
               if(len_s == len_t){
                   return s.substring(i+1).equals(t.substring(i+1));
               }else{
                   return s.substring(i).equals(t.substring(i+1));
               }
           }
       }
        
        return (len_s + 1 == len_t);//if there is no difference on len_s distance, the strings are one edit away only if t has one more character
    }
}


//time O(n)

//space O(n) //create substrings
