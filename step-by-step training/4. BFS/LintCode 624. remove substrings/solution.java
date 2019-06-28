class Solution{
    public int minLength(String s, Set<String> dict){
         Queue<String> que = new LinkedList<String>();
         Set<String> hash = new HashSet<String>();
         
         int min = s.length();
         que.offer(s);
         hash.add(s);
         
         while(!que.isEmpty()){
             s = que.poll();
             for(String sub : dict){//chech each substring in the dict
                int found = s.indexOf(sub);
                while(found != -1){
                    String new_s = s.substring(0,found) + s.substring(found+sub.lenght(),s.length());
                    if(!hash.contains(new_s){
                       if(new_s.length() < min){
                            min = new_s.length();
                            }
                       que.offer(new_s);
                       hash.add(new_s);
                    }
                    found = s.indexOf(sub,found+1);
                }
             }
         }
         return min;
      }
   }
   
