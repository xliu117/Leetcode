class Solution{
    public int[] winSum(int[] nums, int k){
           if(nums.length == 0 || nums == null || k < 0){
                    return  new int[0];
            }
           
            int len = nums.length;
            int[] sums = new int[len - k + 1];
            
            
            
            for(int j = 0; j <= k; j++){
                 sums[0] += nums[j];
            }
            
            //while(j < len){
              //  sums[i] = sum;
                //sum = sum - nums[i++] + nums[++j];
             //}
               
             for(int i = 1; i < sums.length; i++){
                 sums[i] = sums[i-1] - nums[i-1] + nums[i-1+k];
             }
             
             return nums;
            }
            
       }     
