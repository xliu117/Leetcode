//idea: sliding window 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()){
            return list;
        }
        
        
        int m = s.length();
        int n = p.length();
        
        int len = m - n + 1;
        for(int i = 0;  i < len; i++){
           if(isAnagrams(s.substring(i, i+n), p)){
               list.add(i);
           }
        }
        return list;
        
    }
    
    private boolean isAnagrams(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0, n = a.length(); i < n; i++){
            counter[a.charAt(i) - 'a']++;
            counter[b.charAt(i) - 'a']--;
        }
        
        for(int j = 0; j < counter.length; j++){
            if(counter[j] != 0){
                return false;
            }
        }
        
        return true;
    }
}
