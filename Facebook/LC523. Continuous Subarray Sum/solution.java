/**
//brute force

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for(int start = 0; start < nums.length - 1; start++){
            for(int end = start + 1; end < nums.length; end++){
                int sum = 0;
                for(int i = start; i <= end; i++){
                    sum += nums[i];
                }
                
                if(sum == k || (k != 0 && sum % k == 0)){
                    return true;
                }
            }
        }
        return false;
    }
}

//time O(n^3)
//space O(1)
*/


/***
//sum[i]
class Solution{
    public boolean checkSubarraySum(int[] nums, int k){
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        
        for(int start = 0; start < nums.length - 1; start++){
            for(int end = start + 1; end < nums.length; end++){
                int summ = sum[end] - sum[start] + nums[start];
                if(summ == k || (k!=0 && summ % k == 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
}

//time O(n^2)
   //space O(n) 
*/

//hashmap
class Solution{
    public boolean checkSubarraySum(int[] nums, int k){
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0){
                sum = sum % k;
            }
            
            if(map.containsKey(sum)){
                if(i - map.get(sum) > 1){
                    return true;
                }
                    
            }else{
                map.put(sum, i);
            }
        }
        
        return false;
    }
    
    
}

//time O(n)
//space O(min(n,k))

