class TwoSum {
    private HashMap<Integer,Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer,Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!map.containsKey(number)){
            map.put(number,1);
        } 
        else{
            map.put(number,map.get(number) + 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
       for(int key : map.keySet()){
           int target = value - key;
           if(map.containsKey(target)){
               if(target != key || map.get(target) > 1){
                   return true;
               }
           }
       }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

