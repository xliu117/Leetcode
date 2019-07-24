class Pair{
   int val;
   int idx;
   public Pair(int val, int idx){
       this.val = val;
       this.idx = idx;
   }
 }
       
       
class Solution{
    public int[] twoSum7(int[] nums, int target){
         target = Math.abs(target);
         int[] result = new int[2];
         Pair[] pairs = new Pair[nums.length];
         
         for(int i = 0; i < nums.length; i++){
             pairs[i] = new Pair(nums[i], i);
          }
          
          Arrays.sort(pairs,new Comparator<Pair>(){
              public int compare(Pair x, Pair y){
                  return x.val - y.val;
              }
          });
          
          int j = 0;
          for(int i = 0; o < nums.length; i++){
             if(j == i){
                j++;
                }
                
             while(j < nums.length && pairs[j].val - pairs[i].val < target){
                 j++;
              }
              
              if(j < nums.length && pairs[j].val - pairs[i].val == target){
                  result[0] = Math.min(pairs[i].idx, pairs[j].idx) + 1;
                  result[1] = Math.max(pairs[i].idx, pairs[j].idx) + 1;
                  return result;
                  }
             }
             return result;
             
             }
          }   
              
//solution2: use hashmap        
class Solution{
public int[] twoSum7(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int sum = nums[i] + target;
        if (map.containsKey(sum)) {
            int index = map.get(sum);
            int[] pair = new int[2];
            pair[0] = index + 1;
            pair[1] = i + 1;
            return pair;
        }
        
        int diff = nums[i] - target;
        if (map.containsKey(diff)) {
            int index = map.get(diff);
            int[] pair = new int[2];
            pair[0] = index + 1;
            pair[1] = i + 1;
            return pair;
        }
        map.put(nums[i], i);
    }
    
    return null;
}

         
