/***
//solution1: sorting
//two strings are anagrams if and only if their sorted strings are equal.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //corner case
        if(strs.length == 0) return new ArrayList();
        
        //initialize a hashmap, key:sorted string, list:all the same anagrams
        Map<String,List> ans = new HashMap<String, List>();
        
        for(String s : strs){//O(N)
            char[] ca = s.toCharArray();//string to char array
            Arrays.sort(ca);//sort the char array
            String key = String.valueOf(ca);//char array to string
            
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

//time: O(Nklogk)
//space:O(nk)
*/


//solution2: count

class Solution{
    public List<List<String>> groupAnagrams(String[] strs){
        //corner case
        if(strs.length == 0) return new ArrayList();
        
        Map<String, List> ans = new HashMap<String, List>();
        
        int[] count = new int[26];
        for(String s:strs){
            Arrays.fill(count,0);
            for(char c : s.toCharArray()) count[c-'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++){
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        
        return new ArrayList(ans.values());
    }
}

//time O(nk)
//space O(nk)
