/***
//solution1 hashmap
class Solution {
    public boolean canPermutePalindrome(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0, n = s.length(); i < n; i++){
            char c = s.charAt(i);
           map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        int count = 0;
        for(char key : map.keySet()){
            count += map.get(key) %2;
        }
        return count <= 1; 
        
    }
}

//time O(n)
//space O(n)
*/

/***
//solution2 array

class Solution{
    public boolean canPermutePalindrome(String s){
        int[] map = new int[128];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)]++;
        }
        int count = 0;
        for(int key = 0; key < map.length && count <= 1; key++){
            count += map[key] %2;
        }
        return count <= 1;
    }
}
//time O(n)
//space O(1)

*/

//single pass
class Solution{
    public boolean canPermutePalindrome(String s){
        int[] map = new int[128];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)]++;
            if(map[s.charAt(i)] % 2 == 0){
               count--;
            } else{
                count++;
            }
            
        }
        
        return count <= 1;
    }
}
