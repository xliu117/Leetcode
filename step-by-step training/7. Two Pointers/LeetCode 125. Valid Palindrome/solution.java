class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; int j = s.length() - 1;
        while(i < j){
            if(!isValid(s.charAt(i))){
                i++;
                continue;
            }
            if(!isValid(s.charAt(j))){
                j--;
                continue;
            }
            if(!Equal(s.charAt(i), s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean isValid(char c){
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'); 
    }
    
    public boolean Equal(char x, char y){
        if(x >= '0' && x <= '9'){
            return x == y;
        }
        
        return (x == y) || (x + 'A' - 'a' == y) || (y + 'A' - 'a' == x);
    }
}
