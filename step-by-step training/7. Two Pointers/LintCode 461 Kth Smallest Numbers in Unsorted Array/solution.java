class Solution{
   public int kthSmallest(int k, int[] nums){
      return helper(nums, 0, nums.length - 1, k - 1);
   }
   
   public int helper(int[] nums, int lo, int hi, int k){
       if(hi <= lo){
          return nums[hi];
       }
       
       if(pos
