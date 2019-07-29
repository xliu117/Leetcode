class Solution{
    public ArrayList<Integer> subarraySum(int[] nums){
        ArrayList<Integer> res = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSUm = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            prefixsum +=nums[i];
            if(map.containsKey(prefixSum)){
                res.add(map.get(prefixSum)+1);
                res.add(i);
                return res;
            }
            else{
               map.put(prefixSUm,i);
           }
       }
       return res;
     }
  }   
            
          
