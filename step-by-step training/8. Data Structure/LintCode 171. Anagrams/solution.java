//solution1: based on sort

class Solution{
    public List<string> anagrams(String[] strs){
       List<string> results = new ArrayList<String>();
       if(str == null || strs.length == 0){
           return results;
       }
       
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] arr = str[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if(!map.containsKey(s)){
               ArrayList<String> list = new ArrayList<String>();
               map.put(s,list);
            }
            map.get(s).add(strs[i);
          }
          for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
              if(entry.getValue().size() >= 2){
                  results.addAll(entry.getValue());
              }
          }
          return results;
       }
   }
   
   
   
   //solution2: based on hash
   class Solution{
       private int getHash(int[] count){
           int hash = 0;
           int a = 378551;
           int b = 63689;
           for(int num : count){
               hash = hash * a + num;
               a = a * b;
           }
           return hash;
        }
        
        public ArrayList<String> anagrams(String[] strs){
             ArrayList<String> result = new ArrayList<String>();
             HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
             
             for(Sting str : strs){
                 int[] count = new int[26];
                 for(int i = 0; i < str.length(); i++){
                    count[str.charAt(i) - 'a']++;
                  }
                  
                  int hash = getHash(count);
                  if(!map.containsKey(hash)){
                      map.put(has,new ArrayList<String>());
                    }
                    
                    map.get(hash).add(str);
                  }
                  
                  for(ArrayList<String> tmp : map.values()){
                     if(tmp.size() > 1){
                         result.addAll(tmp);
                     }
                  }
                  
                  return result;
              }
          }    
                     
