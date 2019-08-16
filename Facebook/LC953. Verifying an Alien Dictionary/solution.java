//my solution
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //use hashmap to record the order
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0, n = order.length(); i < n; i++){//O(len_s=26) = O(1)
            char c = order.charAt(i);
            map.put(c, i+1);
        }
        
        for(int j = 1, len = words.length; j < len; j++){//O(len_w)
            if(!isSmaller(words[j-1], words[j], map)){//O(len_eachword)
                return false;
            }
        }
        return true;       
    }
    
    
    private boolean isSmaller(String word1, String word2, HashMap<Character, Integer> map){
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        int min = Math.min(m,n);
        while(i < min){
            if(map.get(word1.charAt(i)) > map.get(word2.charAt(i)) ){
                return false;
            }else if(map.get(word1.charAt(i)) == map.get(word2.charAt(i))){
                i++;
            }else{
                return true;
            }
        }
        
        if(m > n){
            return false;
        }else{
            return true;
        }
    }
                                     
}

