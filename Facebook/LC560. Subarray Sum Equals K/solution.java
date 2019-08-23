/***
//prefix sum

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 1){
            if(nums[0] == k) return 1;
            if(nums[0] != k) return 0;
        }
        int count = 0;
        int[] presum = new int[nums.length+1];//presum[i] = presum[i-1] + nums[i-1];
        presum[0]=0;
        for(int i = 1; i <= nums.length; i++){
            presum[i] = presum[i-1] + nums[i-1];
        }
        
        
        
        for(int i = 0; i <= nums.length; i++){
            for(int j = i+1; j <= nums.length; j++){
                if(presum[j] - presum[i] == k){
                    count++;
                }
            }
        }
        
        return count;
    }
}
time O(n^2)
space O(n)
*/
/***
class Solution{
     public int subarraySum(int[] nums, int k) {
         int count = 0;
         for(int i = 0; i < nums.length; i++){
            int sum = 0;
             for(int j = i; j < nums.length; j++){
                 sum += nums[j];
                 if(sum == k){
                     count++;
                 }
             }
         }
         return count;
     }
}
*/
class Solution{
    public int subarraySum(int[] nums, int k){
        int count=0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum -k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}


